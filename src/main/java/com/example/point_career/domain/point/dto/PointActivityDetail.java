package com.example.point_career.domain.point.dto;

import lombok.*;
import com.example.point_career.domain.point.entity.IsPointOnline;
import java.util.List;
//BE-18
@Getter @Setter
public class PointActivityDetail {
    private Long point_id;
    private String point_title;
    private IsPointOnline point_online_type; // 온라인/오프라인/혼합 여부
    private String point_start_time; // LocalDateTime 등으로 교체 가능
    private String point_end_time;   // LocalDateTime 등으로 교체 가능
    private int point_duration;
    private int point_price;
    private List<String> favoriteCategories;
    private List<String> activityCategories;
    private String point_image_url;
    private String point_link_url;
    private String point_deadline;
    private String point_place;
    private String point_dept;
}
