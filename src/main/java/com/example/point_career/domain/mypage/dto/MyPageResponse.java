package com.example.point_career.domain.mypage.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
public class MyPageResponse {
    private ProfileDto profile;
    private List<PointDto> points;
    private List<RecruitDto> recruits;

    @Getter @Builder
    @NoArgsConstructor @AllArgsConstructor
    public static class ProfileDto {
        private String userName;
        private String userMajor;
        private Integer userGrade;
        private String userEmail;
        private String userLoginId;
    }

    @Getter @Builder
    @NoArgsConstructor @AllArgsConstructor
    public static class PointDto {
        private Long pointId;
        private String pointName;
        private LocalDateTime pointDeadline;
        private Integer pointPrice;
        private String pointImageUrl;
        private List<String> favoriteCategories;
        private List<String> activityCategories;
    }

    @Getter @Builder
    @NoArgsConstructor @AllArgsConstructor
    public static class RecruitDto {
        private Long recruitId;
        private String recruitName;
        private String recruitCompany;
        private LocalDateTime recruitDeadline;
        private String recruitImageUrl;
        private List<String> favoriteCategories;
        private List<String> recruitJobCategories;
    }
}