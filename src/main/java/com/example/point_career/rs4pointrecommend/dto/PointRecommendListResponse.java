package com.example.point_career.rs4pointrecommend.dto;

import lombok.*;
import java.util.List;
//BE-12
@Getter @Setter
public class PointRecommendListResponse {
    private List<PointRecommendActivity> activities;
}
