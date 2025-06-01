package com.example.point_career.domain.recruit.dto;

import lombok.*;
import java.util.List;
//BE-20
@Getter @Setter
public class RecruitDetail {
    private Long recruit_id;
    private String recruit_title;
    private boolean recruit_detail;  // 상세정보 포함 여부 등 필요시
    private List<String> recruit_tags;
    private String recruit_image_url;
    private String recruit_link_url;
}
