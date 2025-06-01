package com.example.point_career.domain.user.dto;

import lombok.*;

@Getter @Setter
public class EmailCodeVerifyRequest {
    private String email;
    private String code;
}
