package com.example.point_career.domain.recruit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

//BE-20
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecruitDetailResponse {

    private RecruitDetailDto recruit;
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecruitDetailDto {

        private Long recruitId;
        private String recruitName;
        private String recruitCompany;
        private LocalDateTime recruitDeadline;
        private String recruitPlace;
        private String recruitDetail; //기업 소개
        private String recruitType; //채용 형태 (정규직, 인턴 등)
        private List<String> recruitJobCategories; //채용 직무 카테고리
        private String recruitImageUrl;
        private String recruitLinkUrl;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

    }
}