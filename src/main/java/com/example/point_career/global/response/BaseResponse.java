package com.example.point_career.global.response;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BaseResponse<T> {
    private String status;
    private int code;
    private String message;
    private T result;
}