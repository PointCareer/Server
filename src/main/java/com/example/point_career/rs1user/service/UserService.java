package com.example.point_career.rs1user.service;

import com.example.point_career.rs1user.dto.*;

public interface UserService {
    RegisterResponse register(RegisterRequest request);
    EmailCodeResponse requestEmailCode(EmailCodeRequest request);
    EmailCodeVerifyResponse verifyEmailCode(EmailCodeVerifyRequest request);
    LoginResponse login(LoginRequest request);
}