package com.example.point_career.domain.mypage.controller;

import com.example.point_career.domain.mypage.dto.*;
import com.example.point_career.domain.mypage.service.MyPageService;

import com.example.point_career.global.common.response.BaseResponse;
import com.example.point_career.global.common.response.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

@Tag(name = "RS3: 마이페이지", description = "개인 프로필/북마크/정보 관리 API")
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class MyPageController {

    private final MyPageService mypageService;

    // BE-6 마이페이지 정보 제공
    @Operation(summary = "마이페이지: 프로필 + 포인트·채용 북마크 일괄 조회")
    @GetMapping("/profile")
    public BaseResponse<MyPageResponse> getMyPage(@RequestParam Long userId) {
        return new BaseResponse<>(BaseResponseStatus.SUCCESS, mypageService.getMyPage(userId));
    }

    // BE-9 프로필 수정
    @Operation(summary = "프로필 수정")
    @PutMapping("/profile")
    public BaseResponse<UserProfileUpdateResponse> updateProfile(@RequestBody UserProfileUpdateRequest request) {
        return new BaseResponse<>(BaseResponseStatus.SUCCESS, mypageService.updateProfile(request));
    }
}

