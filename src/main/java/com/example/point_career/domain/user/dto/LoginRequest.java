package com.example.point_career.domain.user.dto;

import lombok.*;

@Getter @Setter
public class LoginRequest {
    private String loginId;
    private String password;
}
