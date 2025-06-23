package com.example.point_career.domain.point.dto;

import lombok.*;
import java.util.List;

//BE-14, 15, 17
@Getter @Setter
public class PointActivity {
    private Long point_id;
    private String point_title;
    private int point_price;
    private String point_deadline;
    private int point_duration;
    private boolean point_online; //dto의 setter충돌로 인해서 is_point_online에서 수정.
    private List<String> favoriteCategories;
    private List<String> activityCategories;
}
