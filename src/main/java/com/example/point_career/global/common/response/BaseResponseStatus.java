package com.example.point_career.global.common.response;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {
	//TODO: 상황에 맞는 메시지 추가해서 사용

	SUCCESS("success", 200, "요청에 성공했습니다."),
	FAIL("fail", 400, "요청에 실패했습니다."),
	VALIDATION_ERROR("fail", 400, "유효성 검사에 실패했습니다.");

	private final String status;
	private final int code;
	private final String message;

	BaseResponseStatus(String status, int code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
}
