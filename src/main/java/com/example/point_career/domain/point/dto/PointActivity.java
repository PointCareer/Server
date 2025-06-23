package com.example.point_career.domain.point.dto;

import lombok.*;
import com.example.point_career.domain.point.entity.IsPointOnline;
import java.util.List;

//BE-14, 15, 17
@Getter @Setter
public class PointActivity {
    private Long point_id;
    private String point_title;
    private int point_price;
    private String point_deadline;
    private int point_duration;
    private IsPointOnline point_online_type;
    private List<String> favoriteCategories;
    private List<String> activityCategories;
}
