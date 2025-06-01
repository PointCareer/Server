package com.example.point_career.domain.mypage.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UserProfile {
    private String user_name;
    private String user_major;
    private String user_grade;
    private List<String> user_favorites;
    private List<String> user_industries;
}
