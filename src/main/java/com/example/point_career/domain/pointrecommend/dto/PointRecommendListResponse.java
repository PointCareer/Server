package com.example.point_career.domain.pointrecommend.dto;

import lombok.*;
import java.util.List;
//BE-11
@Getter @Setter @Builder
public class PointRecommendListResponse {
    private List<RecommendGroup> recommendation_groups;
}
