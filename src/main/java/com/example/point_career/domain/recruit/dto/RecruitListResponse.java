package com.example.point_career.domain.recruit.dto;

import com.example.point_career.domain.recruit.entity.RecruitType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecruitListResponse {
    private List<RecruitDto> recruits;

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
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