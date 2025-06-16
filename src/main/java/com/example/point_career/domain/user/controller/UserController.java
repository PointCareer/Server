package com.example.point_career.domain.user.controller;

import com.example.point_career.domain.user.dto.EmailCodeRequest;
import com.example.point_career.domain.user.dto.EmailCodeVerifyRequest;
import com.example.point_career.domain.user.dto.LoginResult;
import com.example.point_career.domain.user.dto.RegisterRequest;
import com.example.point_career.domain.user.service.UserService;
import com.example.point_career.domain.user.service.UserServiceImpl;
import com.example.point_career.global.common.response.BaseResponse;
import com.example.point_career.domain.user.dto.EmailCodeResponse;
import com.example.point_career.domain.user.dto.EmailCodeVerifyResponse;
import com.example.point_career.domain.user.dto.LoginRequest;
import com.example.point_career.domain.user.dto.LoginResponse;
import com.example.point_career.domain.user.dto.RegisterResponse;
import com.example.point_career.global.common.response.BaseResponseStatus;
import io.swagger.v3.oas.annotations.Operation;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "RS1: 유저관리", description = "회원가입/로그인/이메일 인증 등 유저관리 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class UserController {

	private final UserServiceImpl userService;

	// BE-1 회원가입
	@Operation(summary = "회원가입")
	@PostMapping("/register")
	public BaseResponse<RegisterResponse> register(@RequestBody RegisterRequest request) {
		return new BaseResponse<>(BaseResponseStatus.REGISTER_SUCCESS, userService.register(request));
	}

	// 이메일 중복 체크
	@Operation(summary = "이메일 중복 체크")
	@GetMapping()
	public BaseResponse<Void> checkEmail (@RequestParam String email) {
		userService.checkEmail(email);
		return new BaseResponse<>(BaseResponseStatus.CHECK_EMAIL_SUCCESS);
	}

	// BE-2 이메일 인증 코드 요청
	@Operation(summary = "이메일 인증 코드 요청")
	@PostMapping("/email/code/request")
	public BaseResponse<EmailCodeResponse> requestEmailCode(@RequestBody EmailCodeRequest request) {
		// TODO: 인증코드 생성 및 발송
		return null;
	}

	// BE-3 이메일 인증 코드 검증
	@Operation(summary = "이메일 인증 코드 검증")
	@PostMapping("/email/code/verify")
	public BaseResponse<EmailCodeVerifyResponse> verifyEmailCode(@RequestBody EmailCodeVerifyRequest request) {
		// TODO: 인증코드 검증 및 인증 처리
		return null;
	}

	// BE-4 로그인
	@Operation(summary = "로그인")
	@PostMapping("/login")
	public ResponseEntity<BaseResponse<LoginResponse>> login(@RequestBody LoginRequest request) {
		LoginResult loginResult = userService.login(request);

		String accessToken = loginResult.getAccessToken();
		String refreshToken = loginResult.getRefreshToken();
		LoginResponse loginResponse = loginResult.getLoginResponse();

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("Authorization", "Bearer " + accessToken);
		httpHeaders.set("Authorization_refresh", "Bearer " + refreshToken);

		return new ResponseEntity<>(new BaseResponse<>(BaseResponseStatus.LOGIN_SUCCESS, loginResponse), httpHeaders,
				HttpStatus.OK);
	}
}
