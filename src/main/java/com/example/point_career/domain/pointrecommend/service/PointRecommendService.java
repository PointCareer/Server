package com.example.point_career.domain.pointrecommend.service;

import com.example.point_career.domain.pointrecommend.dto.PointRecommendInputRequest;
import com.example.point_career.domain.pointrecommend.dto.PointRecommendInputResponse;
import com.example.point_career.domain.pointrecommend.dto.PointRecommendListResponse;
import com.example.point_career.domain.pointrecommend.dto.PointRecommendResultResponse;

public interface PointRecommendService {
    PointRecommendInputResponse recommendInput(PointRecommendInputRequest request);
    PointRecommendResultResponse recommendResult();
    PointRecommendListResponse recommendList();
}
