package com.example.point_career.domain.mainpage.controller;

import com.example.point_career.global.common.response.BaseResponse;
import com.example.point_career.domain.mainpage.dto.UserMeResponse;
import org.springframework.web.bind.annotation.*;
import com.example.point_career.global.common.response.BaseResponseStatus;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import com.example.point_career.domain.mainpage.service.MainPageService;
import com.example.point_career.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Tag(name = "RS2: 메인페이지", description = "사용자 메인화면/기본정보 관련 API")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class MainPageController {

    private final MainPageService mainPageService;

    // BE-5 사용자 기본정보 조회
    @Operation(summary = "사용자 기본정보 조회")
    @GetMapping("/me")
    public BaseResponse<UserMeResponse> getMe(@AuthenticationPrincipal User user) {
        return new BaseResponse<>(BaseResponseStatus.SUCCESS, mainPageService.getMe(user));
    }
}
