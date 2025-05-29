package com.example.point_career.rs4pointrecommend.dto;

import lombok.*;
import java.util.List;
//BE-11
@Getter @Setter
public class PointRecommendResultResponse {
    private List<RecommendGroup> recommendationGroups;
}
