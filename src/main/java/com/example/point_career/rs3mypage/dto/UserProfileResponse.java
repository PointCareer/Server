package com.example.point_career.rs3mypage.dto;

import lombok.*;
import java.util.List;

@Getter @Setter
public class UserProfileResponse {
    private UserProfile profile;
    private Bookmarks bookmarks;
}

@Getter @Setter
public class UserProfile {
    private String user_name;
    private String user_major;
    private String user_grade;
    private List<String> user_favorites;
    private List<String> user_industries;
}

@Getter @Setter
public class Bookmarks {
    private List<PointBookmark> points;
    private List<RecruitBookmark> recruits;
}

@Getter @Setter
public class PointBookmark {
    private Long point_id;
    private String point_title;
    private int point_price;
    private String point_deadline;
    private int point_duration;
    private boolean is_point_online;
    private String point_link_url;
}

@Getter @Setter
public class RecruitBookmark {
    private Long recruit_id;
    private String recruit_title;
    private String recruit_deadline;
    private List<String> tag;
}