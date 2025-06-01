package com.example.point_career.rs5point.service;

import com.example.point_career.rs5point.dto.*;

public interface PointActivityService {
    PointActivityListResponse getPointActivities();
    PointActivityListResponse searchPointActivities(String keyword);
    PointActivityListResponse filterPointActivities(String filter, String sort);
    PointActivityDetailResponse getPointActivityDetail(Long pointId);
}