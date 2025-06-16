package com.example.point_career.domain.mypage.dto;

import com.example.point_career.domain.category.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileUpdateResponse {
    private Long userId;
    private String major;
    private Integer grade;
    private List<Category> favorite; // 관심 분야(ENUM)
}
