package com.example.point_career.global.common.response;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {
	//TODO: 상황에 맞는 메시지 추가해서 사용

	/**
	 * 200xx : OK
	 */
	SUCCESS(20000, "요청이 성공적으로 처리되었습니다."),
	LOGIN_SUCCESS(20001, "로그인에 성공했습니다."),
	REGISTER_SUCCESS(20002, "회원가입에 성공했습니다."),

	/**
	 * 400xx : Bad Request
	 */
	BAD_REQUEST(40000, "잘못된 요청입니다."),
	VALIDATION_ERROR(40001, "유효성 검사에 실패했습니다."),
	PASSWORD_ERROR(40002, "유효하지 않은 비밀번호입니다."),
	PASSWORDS_DO_NOT_MATCH(40003, "비밀번호와 비밀번호 확인이 일치하지 않습니다."),

	/**
	 * 401xx : Unauthorized
	 */
	// JWT Token ERROR
	ACCESSTOKEN_EXPIRED(40101, "유효하지 않은 Access Token입니다."),
	REFRESHTOKEN_EXPIRED(40102, "유효하지 않은 Refresh Token입니다."),
	UNSUPPORTED_TOKEN(40103, "지원하지 않는 Token 입니다."),
	WRONG_TYPE_TOKEN(40104, "시그니처 검증에 실패한 Token 입니다."),
	DAMAGED_TOKEN(40105, "손상된 Token 입니다."),

	/**
	 * 404xx : Not Found
	 */
	//User
	USER_NOT_EXIST(40401, "존재하지 않는 회원입니다."),

	/**
	 * 409xx : Conflict
	 */
	DUPLICATE_EMAIL(40901, "이미 존재하는 이메일입니다."),
	DUPLICATE_LOGIN_ID(40902, "이미 존재하는 로그인 아이디입니다."),

	/**
	 * 403 : Forbidden
	 */
	FORBIDDEN(403, "접근이 거부되었습니다."),

	/**
	 * 500 : Internal Server Error
	 */
	INTERNAL_SERVER_ERROR(50000, "서버 내부 오류가 발생했습니다.");

	private final int code;
	private final String message;

	BaseResponseStatus(int code, String message) {
		this.code = code;
		this.message = message;
	}
}
