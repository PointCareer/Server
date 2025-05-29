package com.example.point_career.rs4pointrecommend.dto;

import lombok.*;
//BE-11, BE-12
@Getter @Setter
public class PointRecommendActivity {
    private Long point_id;
    private String point_title;
    private int point_price;
    private String point_deadline;
    private int point_duration;
    private boolean is_point_online;
    private String point_link_url;
}