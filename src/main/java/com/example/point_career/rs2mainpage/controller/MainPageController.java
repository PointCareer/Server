package com.example.point_career.rs2mainpage.controller;

import com.example.point_career.global.response.BaseResponse;
import com.example.point_career.rs2mainpage.dto.UserMeResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class MainPageController {

    // BE-5 사용자 기본정보 조회
    @GetMapping("/me")
    public BaseResponse<UserMeResponse> getMe() {
        // TODO: 토큰 인증 후 유저 정보 반환
        return null;
    }
}