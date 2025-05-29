package com.example.point_career.rs3mypage.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Bookmarks {
    private List<PointBookmark> points;
    private List<RecruitBookmark> recruits;
}
