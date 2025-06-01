package com.example.point_career.domain.pointrecommend.dto;

import lombok.*;
import java.util.List;
//BE-11
@Getter @Setter
public class PointRecommendResultResponse {
    private List<RecommendGroup> recommendationGroups;
}
