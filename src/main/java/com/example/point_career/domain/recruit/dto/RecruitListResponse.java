package com.example.point_career.domain.recruit.dto;

import lombok.*;
import java.util.List;
//BE-19, 21
@Getter @Setter
public class RecruitListResponse {
    private List<Recruit> recruits;
}
