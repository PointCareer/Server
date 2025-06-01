package com.example.point_career.domain.point.dto;

import lombok.*;
import java.util.List;
//BE-18
@Getter @Setter
public class PointActivityDetail {
    private Long point_id;
    private String point_title;
    private boolean is_point_online;
    private String point_start_time; // LocalDateTime 등으로 교체 가능
    private String point_end_time;   // LocalDateTime 등으로 교체 가능
    private int point_price;
    private String point_summary;
    private List<String> point_tags;
    private String point_image_url;
    private String point_link_url;
}
