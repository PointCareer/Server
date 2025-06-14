package com.example.point_career.domain.recruit.dto;

import com.example.point_career.domain.recruit.entity.Recruit;
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
        private String recruitDetail;
        private String recruitType;
        private List<String> recruitJobCategories;
        private String recruitImageUrl;
        private String recruitLinkUrl;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

    }
}
