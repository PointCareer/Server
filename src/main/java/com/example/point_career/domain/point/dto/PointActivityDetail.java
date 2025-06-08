package com.example.point_career.domain.point.dto;

import lombok.*;
import java.util.List;
//BE-18
@Getter @Setter
public class PointActivityDetail {
    private Long point_id;
    private String point_title;
    private boolean point_online; //dto의 setter충돌로 인해서 is_point_online에서 수정.
    private String point_start_time; // LocalDateTime 등으로 교체 가능
    private String point_end_time;   // LocalDateTime 등으로 교체 가능
    private int point_duration;
    private int point_price;
    private List<Long> Activity_category;
    private String point_image_url;
    private String point_link_url;
    //place랑 dept는 API명세어 없어서 사용아직 안함.
}
