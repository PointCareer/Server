package com.example.point_career.domain.user.dto;

import lombok.*;

@Getter @Setter @Builder
public class RegisterResponse {
    private Long user_id;
    private Boolean is_email_verified;
}
