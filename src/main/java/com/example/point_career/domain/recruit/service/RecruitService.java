package com.example.point_career.domain.recruit.service;

import com.example.point_career.domain.recruit.dto.RecruitDetailResponse;
import com.example.point_career.domain.recruit.dto.RecruitListResponse;

public interface RecruitService {
    RecruitListResponse getRecruits();
    RecruitDetailResponse getRecruitDetail(Long recruitId);
    RecruitListResponse searchRecruits(String keyword);
}
