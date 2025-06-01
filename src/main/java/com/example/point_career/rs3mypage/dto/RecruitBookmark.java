package com.example.point_career.rs3mypage.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class RecruitBookmark {
    private Long recruit_id;
    private String recruit_title;
    private String recruit_deadline;
    private List<String> tag;
}
