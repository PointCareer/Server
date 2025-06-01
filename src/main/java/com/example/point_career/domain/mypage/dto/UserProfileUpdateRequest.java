package com.example.point_career.domain.mypage.dto;

import lombok.*;
import java.util.List;

@Getter @Setter
public class UserProfileUpdateRequest {
    private Long userId;
    private String department;
    private String schoolYear;
    private List<Long> favoriteIds;
    private List<Long> industriesIds;
}
