package com.example.point_career.domain.recruit.dto;

import lombok.*;
import java.util.List;
//BE-19, 21
@Getter @Setter
public class Recruit {
    private Long recruit_id;
    private String recruit_title;
    private String recruit_company;
    private String recruit_deadline; // LocalDateTime 등으로 교체 가능
    private List<String> recruit_tags;
}
