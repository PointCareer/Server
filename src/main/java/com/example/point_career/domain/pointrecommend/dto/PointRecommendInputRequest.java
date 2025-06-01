package com.example.point_career.domain.pointrecommend.dto;

import lombok.*;
import java.util.List;
//BE-10
@Getter @Setter
public class PointRecommendInputRequest {
    private Long userId;
    private int requiredPoints;
    private int currentPoints;
    private List<Long> favoriteIds;
    private List<Long> industriesIds;
}
