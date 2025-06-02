package com.example.point_career.domain.user.dto;

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
    private int grade;
    private String semester;
    private int userPoint;
    private int remainPoint;
//    private List<Long> favorites;
}
