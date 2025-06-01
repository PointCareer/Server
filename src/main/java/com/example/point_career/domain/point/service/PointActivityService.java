package com.example.point_career.domain.point.service;

import com.example.point_career.domain.point.dto.PointActivityDetailResponse;
import com.example.point_career.domain.point.dto.PointActivityListResponse;

public interface PointActivityService {
    PointActivityListResponse getPointActivities();
    PointActivityListResponse searchPointActivities(String keyword);
    PointActivityListResponse filterPointActivities(String filter, String sort);
    PointActivityDetailResponse getPointActivityDetail(Long pointId);
}
