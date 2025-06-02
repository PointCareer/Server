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
import com.example.point_career.domain.user.entity.User;
import com.example.point_career.domain.user.repository.UserRepository;
import com.example.point_career.global.auth.jwt.JwtUtil;
import com.example.point_career.global.common.response.BaseException;
import com.example.point_career.global.common.response.BaseResponse;
import com.example.point_career.global.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final JwtUtil jwtUtil;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Override
	public RegisterResponse register(RegisterRequest request) {
		return null;
	}

	@Override
	public EmailCodeResponse requestEmailCode(EmailCodeRequest request) {
		return null;
	}

	@Override
	public EmailCodeVerifyResponse verifyEmailCode(EmailCodeVerifyRequest request) {
		return null;
	}

	@Override
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
