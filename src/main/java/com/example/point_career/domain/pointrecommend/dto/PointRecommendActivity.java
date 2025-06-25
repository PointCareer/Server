package com.example.point_career.domain.pointrecommend.dto;

import com.example.point_career.domain.category.entity.CategoryName;
import com.example.point_career.domain.category.entity.PointCategory;
import com.example.point_career.domain.point.entity.IsPointOnline;
import com.example.point_career.domain.point.entity.PointDuration;
import java.util.List;
import lombok.*;
//BE-11, BE-12
@Getter @Setter @Builder
public class PointRecommendActivity {
    private Long point_id;
    private int point_price;
    private IsPointOnline is_point_online;
    private PointDuration point_duration;
    private String point_image_url;
    private String point_title;
    private List<CategoryName> point_categories; //TODO: 카테고리의 이름을 반환해야 됨
    private String point_link_url;
}
