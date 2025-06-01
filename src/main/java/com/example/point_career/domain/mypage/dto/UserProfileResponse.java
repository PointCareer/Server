package com.example.point_career.domain.mypage.dto;

import lombok.*;

@Getter @Setter
public class UserProfileResponse {
    private UserProfile profile;
    private Bookmarks bookmarks;
}

