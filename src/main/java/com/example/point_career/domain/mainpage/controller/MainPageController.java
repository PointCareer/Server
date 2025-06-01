package com.example.point_career.domain.mainpage.controller;

import com.example.point_career.global.response.BaseResponse;
import com.example.point_career.domain.mainpage.dto.UserMeResponse;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@Tag(name = "RS2: 메인페이지", description = "사용자 메인화면/기본정보 관련 API")
@RestController
@RequestMapping("/api/v1/users")
public class MainPageController {

    // BE-5 사용자 기본정보 조회
    @Operation(summary = "사용자 기본정보 조회")
    @GetMapping("/me")
    public BaseResponse<UserMeResponse> getMe() {
        // TODO: 토큰 인증 후 유저 정보 반환
        return null;
    }
}
