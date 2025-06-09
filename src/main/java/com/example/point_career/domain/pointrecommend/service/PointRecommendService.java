package com.example.point_career.domain.pointrecommend.service;

import com.example.point_career.domain.category.entity.CategoryName;
import com.example.point_career.domain.pointrecommend.dto.PointRecommendListResponse;
import java.time.LocalDateTime;
import java.util.List;

public interface PointRecommendService {
//    PointRecommendInputResponse recommendInput(PointRecommendInputRequest request);
//    PointRecommendResultResponse recommendResult();
    PointRecommendListResponse recommendList(int point, LocalDateTime deadline, List<CategoryName> favorite);
}
