package com.example.point_career.domain.pointrecommend.dto;

import lombok.*;
import java.util.List;
//BE-12
@Getter @Setter
public class PointRecommendListResponse {
    private List<PointRecommendActivity> activities;
}
