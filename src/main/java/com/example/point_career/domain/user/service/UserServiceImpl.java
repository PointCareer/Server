package com.example.point_career.domain.user.service;

import com.example.point_career.domain.user.dto.EmailCodeRequest;
import com.example.point_career.domain.user.dto.EmailCodeResponse;
import com.example.point_career.domain.user.dto.EmailCodeVerifyRequest;
import com.example.point_career.domain.user.dto.EmailCodeVerifyResponse;
import com.example.point_career.domain.user.dto.LoginRequest;
import com.example.point_career.domain.user.dto.LoginResponse;
import com.example.point_career.domain.user.dto.LoginResult;
import com.example.point_career.domain.user.dto.RegisterRequest;
import com.example.point_career.domain.user.dto.RegisterResponse;
import com.example.point_career.domain.user.entity.EmailCode;
import com.example.point_career.domain.user.entity.RefreshToken;
import com.example.point_career.domain.user.entity.User;
import com.example.point_career.domain.user.repository.EmailCodeRepository;
import com.example.point_career.domain.user.repository.RefreshTokenRepository;
import com.example.point_career.domain.user.repository.UserRepository;
import com.example.point_career.global.auth.jwt.JwtUtil;
import com.example.point_career.global.common.response.BaseException;
import com.example.point_career.global.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.security.SecureRandom;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

        private final JwtUtil jwtUtil;
        private final UserRepository userRepository;
        private final PasswordEncoder passwordEncoder;
        private final EmailCodeRepository emailCodeRepository;
        @Value("${jwt.refresh-token.expiration-time}")
        private Long refreshTokenExpirationTime;
        private final RefreshTokenRepository refreshTokenRepository;

	@Override
	@Transactional
	public RegisterResponse register(RegisterRequest request) {

		// 1. 로그인 아이디 중복 체크
		if (userRepository.existsByLoginId(request.getLoginId())) {
			throw new BaseException(BaseResponseStatus.DUPLICATE_LOGIN_ID);
		}

		// 2. 이메일 중복 체크
		if (userRepository.existsByEmail(request.getEmail())) {
			throw new BaseException(BaseResponseStatus.DUPLICATE_EMAIL);
		}

		// 3. 비밀번호와 비밀번호 확인 일치 체크
		if (!request.getPassword().equals(request.getConfirmPassword())) {
			throw new BaseException(BaseResponseStatus.PASSWORDS_DO_NOT_MATCH);
		}

		// 4. 비밀번호 암호화
		String encodedPassword = passwordEncoder.encode(request.getPassword());

		// 5. 사용자 생성
		User user = User.builder()
				.loginId(request.getLoginId())
				.email(request.getEmail())
				.password(encodedPassword)
				.name(request.getName())
				.major(request.getMajor())
				.grade(request.getGrade())
				.semester(request.getSemester())
				.userPoint(request.getUserPoint())
				.remainPoint(request.getRemainPoint())
				.emailVerified(false)
				.build();
		// 5. 저장
		userRepository.save(user);

		return RegisterResponse.builder()
				.is_email_verified(user.getEmailVerified())
				.user_id(user.getId())
				.build();
	}

        @Override
        public EmailCodeResponse requestEmailCode(EmailCodeRequest request) {
                if (!userRepository.existsByEmail(request.getEmail())) {
                        throw new BaseException(BaseResponseStatus.EMAIL_NOT_EXIST);
                }

                String code = String.format("%06d", new SecureRandom().nextInt(1000000));
                EmailCode emailCode = new EmailCode(request.getEmail(), code, 300L);
                emailCodeRepository.save(emailCode);

                System.out.println("Send verification code to " + request.getEmail() + ": " + code);

                return new EmailCodeResponse();
        }

        @Override
        public EmailCodeVerifyResponse verifyEmailCode(EmailCodeVerifyRequest request) {
                EmailCode savedCode = emailCodeRepository.findById(request.getEmail())
                                .orElseThrow(() -> new BaseException(BaseResponseStatus.EMAIL_CODE_INVALID));

                if (!savedCode.getCode().equals(request.getCode())) {
                        throw new BaseException(BaseResponseStatus.EMAIL_CODE_INVALID);
                }

                User user = userRepository.findByEmail(request.getEmail())
                                .orElseThrow(() -> new BaseException(BaseResponseStatus.USER_NOT_EXIST));
                user.setEmailVerified(true);
                userRepository.save(user);
                emailCodeRepository.deleteById(request.getEmail());

                EmailCodeVerifyResponse response = new EmailCodeVerifyResponse();
                response.setIs_email_verified(user.getEmailVerified());
                return response;
        }

	@Override
	@Transactional
	public LoginResult login(LoginRequest request) {
		// 1. 사용자 조회
		User findUser = userRepository.findByLoginId(request.getLoginId())
				.orElseThrow(() -> new BaseException(BaseResponseStatus.USER_NOT_EXIST));

		// 2. 비밀번호 확인
		if (!passwordEncoder.matches(request.getPassword(), findUser.getPassword())) {
			throw new BaseException(BaseResponseStatus.PASSWORD_ERROR);
		}

		String accessToken = jwtUtil.generateAccessToken(findUser.getId(), findUser.getName());
		String refreshToken = jwtUtil.generateRefreshToken(findUser.getId(), findUser.getName());

		RefreshToken addRefreshToken = new RefreshToken(findUser.getId(), refreshToken, refreshTokenExpirationTime);
		refreshTokenRepository.save(addRefreshToken);

		LoginResponse loginResponse = LoginResponse.builder()
				.user_id(findUser.getId())
				.build();

		return LoginResult.builder()
				.accessToken(accessToken)
				.refreshToken(refreshToken)
				.loginResponse(loginResponse)
				.build();
	}
}
