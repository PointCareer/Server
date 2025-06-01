package com.example.point_career.rs6recruit.service;

import com.example.point_career.rs6recruit.dto.*;

public interface RecruitService {
    RecruitListResponse getRecruits();
    RecruitDetailResponse getRecruitDetail(Long recruitId);
    RecruitListResponse searchRecruits(String keyword);
}