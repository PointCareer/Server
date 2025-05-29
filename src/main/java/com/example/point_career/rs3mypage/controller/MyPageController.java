package com.example.point_career.rs3mypage.controller;

import com.example.point_career.global.response.BaseResponse;
import com.example.point_career.rs3mypage.dto.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class MyPageController {

    // BE-6 마이페이지 정보 제공
    @GetMapping("/profile")
    public BaseResponse<UserProfileResponse> getProfile() {
        // TODO: 마이페이지 정보 제공
        return null;
    }

    // BE-7 내가 찜한 포인트 활동 목록 조회
    @GetMapping("/profile/bookmarks/point")
    public BaseResponse<PointBookmarkListResponse> getPointBookmarks() {
        // TODO: 북마크된 포인트 활동 조회
        return null;
    }

    // BE-8 내가 찜한 교내 추천 채용 목록 조회
    @GetMapping("/profile/bookmarks/recruit")
    public BaseResponse<RecruitBookmarkListResponse> getRecruitBookmarks() {
        // TODO: 북마크된 채용공고 조회
        return null;
    }

    // BE-9 프로필 수정
    @PutMapping("/profile")
    public BaseResponse<UserProfileUpdateResponse> updateProfile(@RequestBody UserProfileUpdateRequest request) {
        // TODO: 프로필 수정
        return null;
    }
}
