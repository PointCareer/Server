package com.example.point_career.rs3mypage.service;

import com.example.point_career.rs3mypage.dto.*;

public interface MyPageService {
    UserProfileResponse getProfile();
    PointBookmarkListResponse getPointBookmarks();
    RecruitBookmarkListResponse getRecruitBookmarks();
    UserProfileUpdateResponse updateProfile(UserProfileUpdateRequest request);
}
