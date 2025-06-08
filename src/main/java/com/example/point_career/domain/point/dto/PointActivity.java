package com.example.point_career.domain.point.dto;

import lombok.*;
//BE-14, 15, 17
@Getter @Setter
public class PointActivity {
    private Long point_id;
    private String point_title;
    private int point_price;
    private String point_deadline;
    private int point_duration;
    private boolean point_online;
    private String point_tag;
}
