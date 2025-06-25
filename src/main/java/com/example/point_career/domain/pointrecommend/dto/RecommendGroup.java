package com.example.point_career.domain.pointrecommend.dto;

import lombok.*;
import java.util.List;
//BE-11, BE-12
@Getter @Setter @Builder
public class RecommendGroup {
    private String group_name;
    private int target_points;
    private int recommended_points;
    private int lacking_points;
    private boolean is_target_point_satisfied;
    private List<PointRecommendActivity> activities;

}
