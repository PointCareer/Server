package com.example.point_career.domain.mypage.service;

import com.example.point_career.domain.mypage.dto.PointBookmarkListResponse;
import com.example.point_career.domain.mypage.dto.RecruitBookmarkListResponse;
import com.example.point_career.domain.mypage.dto.UserProfileResponse;
import com.example.point_career.domain.mypage.dto.UserProfileUpdateRequest;
import com.example.point_career.domain.mypage.dto.UserProfileUpdateResponse;

public interface MyPageService {
    UserProfileResponse getProfile();
    PointBookmarkListResponse getPointBookmarks();
    RecruitBookmarkListResponse getRecruitBookmarks();
    UserProfileUpdateResponse updateProfile(UserProfileUpdateRequest request);
}
