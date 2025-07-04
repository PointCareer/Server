package com.example.point_career.domain.mypage.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PointBookmark {
    private Long point_id;
    private String point_title;
    private int point_price;
    private String point_deadline;
    private int point_duration;
    private boolean is_point_online;
    private String point_link_url;
}
