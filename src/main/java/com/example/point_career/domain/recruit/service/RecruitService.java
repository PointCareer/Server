package com.example.point_career.domain.recruit.service;

import com.example.point_career.domain.recruit.dto.RecruitDetailResponse;
import com.example.point_career.domain.recruit.dto.RecruitListResponse;
import com.example.point_career.domain.recruit.entity.Recruit;

import java.util.List;

public interface RecruitService {
    RecruitListResponse getRecruits();
    RecruitDetailResponse getRecruitDetail(Long recruitId);
    RecruitListResponse searchRecruits(String keyword);
    RecruitListResponse getRecruitsSorted(String sortType);
}

