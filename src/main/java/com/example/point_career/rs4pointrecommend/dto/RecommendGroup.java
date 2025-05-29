package com.example.point_career.rs4pointrecommend.dto;

import lombok.*;
import java.util.List;
//BE-11, BE-12
@Getter @Setter
public class RecommendGroup {
    private String groupName;
    private List<PointRecommendActivity> activities;
}
