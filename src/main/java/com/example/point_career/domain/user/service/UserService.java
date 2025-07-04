package com.example.point_career.domain.user.service;

import com.example.point_career.domain.user.dto.EmailCodeRequest;
import com.example.point_career.domain.user.dto.EmailCodeVerifyRequest;
import com.example.point_career.domain.user.dto.LoginResult;
import com.example.point_career.domain.user.dto.RegisterRequest;
import com.example.point_career.domain.user.dto.EmailCodeResponse;
import com.example.point_career.domain.user.dto.EmailCodeVerifyResponse;
import com.example.point_career.domain.user.dto.LoginRequest;
import com.example.point_career.domain.user.dto.LoginResponse;
import com.example.point_career.domain.user.dto.RegisterResponse;

public interface UserService {
    RegisterResponse register(RegisterRequest request);
    void checkEmail(String email);
    EmailCodeResponse requestEmailCode(EmailCodeRequest request);
    EmailCodeVerifyResponse verifyEmailCode(EmailCodeVerifyRequest request);
    LoginResult login(LoginRequest request);
}
