package com.example.point_career.global.auth.jwt;

import com.example.point_career.global.common.response.BaseResponseStatus;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtUtil {
	private SecretKey secretKey;

	@Value("${jwt.access-token.expiration-time}")
	private Long accessTokenExpirationTime;

	@Value("${jwt.refresh-token.expiration-time}")
	private Long refreshTokenExpirationTime;

	public JwtUtil(@Value("${spring.jwt.secret}") String secret) {
		secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),
				Jwts.SIG.HS256.key().build().getAlgorithm());
	}

	// Access Token 생성
	public String generateAccessToken(Long userId, String name) {
		return createJwt(userId, name, Duration.ofSeconds(accessTokenExpirationTime).toMillis());
	}

	// Refresh Token 생성
	public String generateRefreshToken(Long userId, String name) {
		return createJwt(userId, name, Duration.ofSeconds(refreshTokenExpirationTime).toMillis());
	}

	public Long getUserId(String token) {
		return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload()
				.get("userId", Long.class);
	}

	public String getName(String token) {

		return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload()
				.get("name", String.class);
	}

	public String createJwt(Long userId, String name, Long tokenValidTime) {
		return Jwts.builder()
				.claim("userId", userId)
				.claim("name", name)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + tokenValidTime))
				.signWith(secretKey)
				.compact();
	}

	public boolean isExpired(String token) {
		Jws<Claims> claims = Jwts.parser()
				.verifyWith(secretKey)
				.build()
				.parseSignedClaims(token);
		return claims.getPayload().getExpiration().before(new Date()); // Token 만료 날짜가 지금보다 이전이면 만료
	}

	public String resolveToken(HttpServletRequest httpServletRequest) {
		String token = httpServletRequest.getHeader("Authorization");
		if (token != null && token.startsWith("Bearer ")) {
			token = token.substring(7);
			return token;
		}
		return null;
	}

	//토큰 유효성 검사
	public boolean validateToken(String token) {
		try {
			return !isExpired(token);
		} catch (SignatureException e) {
			throw new JwtException(BaseResponseStatus.WRONG_TYPE_TOKEN.getMessage());
		} catch (MalformedJwtException e) {
			throw new JwtException(BaseResponseStatus.DAMAGED_TOKEN.getMessage());
		} catch (ExpiredJwtException e) {
			throw new JwtException(BaseResponseStatus.ACCESSTOKEN_EXPIRED.getMessage());
		} catch (UnsupportedJwtException e) {
			throw new JwtException(BaseResponseStatus.UNSUPPORTED_TOKEN.getMessage());
		} catch (NullPointerException e) {
			throw new JwtException(BaseResponseStatus.USER_NOT_EXIST.getMessage());
		}
	}
}
