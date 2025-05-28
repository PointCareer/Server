package com.example.point_career.rs1user.dto;

import lombok.*;
import java.util.List;

@Getter @Setter
public class RegisterRequest {
    private String name;
    private String email;
    private String loginId;
    private String password;
    private String confirmPassword;
    private String major;
    private String grade;
    private String semester;
    private List<Long> favorites;
}