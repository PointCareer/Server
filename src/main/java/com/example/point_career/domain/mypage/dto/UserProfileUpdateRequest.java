package com.example.point_career.domain.mypage.dto;

import com.example.point_career.domain.category.entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserProfileUpdateRequest {
    private Long userId;                 // 사용자 ID
    private String major;                // 학과
    private String semester;             // 학기
    private Integer grade;               // 학년
    private List<Category> favorite;     // 관심 분야(ENUM)
}
