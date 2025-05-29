package com.example.point_career.rs4pointrecommend.service;

import com.example.point_career.rs4pointrecommend.dto.*;

public interface PointRecommendService {
    PointRecommendInputResponse recommendInput(PointRecommendInputRequest request);
    PointRecommendResultResponse recommendResult();
    PointRecommendListResponse recommendList();
}