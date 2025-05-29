package com.example.point_career.global.response;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class BaseResponse<T> {
    private String status;   // "success" or "fail"
    private int code;        // 성공/에러 코드 (예: 200, 400, 500 등)
    private String message;  // 코드에 따른 한글/영문 메시지
    private T result;        // 결과값(성공시), 실패시 null

    //BaseResponse를 통한 성공 실패 응답 형태 고려 방안1.
//    public static <T> BaseResponse<T> success(T result, String message) {
//        return new BaseResponse<>("success", 200, message, result);
//    }
//    public static <T> BaseResponse<T> fail(int code, String message) {
//        return new BaseResponse<>("fail", code, message, null);
//    }
}