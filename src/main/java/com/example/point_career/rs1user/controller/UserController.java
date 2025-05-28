package com.example.point_career.rs1user.controller;

import com.example.point_career.rs1user.dto.*;
import com.example.point_career.global.response.BaseResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    // BE-1 회원가입
    @PostMapping("/register")
    public BaseResponse<RegisterResponse> register(@RequestBody RegisterRequest request) {
        // TODO: 회원가입 처리
        return null;
    }

    // BE-2 이메일 인증 코드 요청
    @PostMapping("/email/code/request")
    public BaseResponse<EmailCodeResponse> requestEmailCode(@RequestBody EmailCodeRequest request) {
        // TODO: 인증코드 생성 및 발송
        return null;
    }

    // BE-3 이메일 인증 코드 검증
    @PostMapping("/email/code/verify")
    public BaseResponse<EmailCodeVerifyResponse> verifyEmailCode(@RequestBody EmailCodeVerifyRequest request) {
        // TODO: 인증코드 검증 및 인증 처리
        return null;
    }

    // BE-4 로그인
    @PostMapping("/login")
    public BaseResponse<LoginResponse> login(@RequestBody LoginRequest request) {
        // TODO: 로그인 처리 및 토큰 발급
        return null;
    }
}