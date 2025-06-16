package com.example.point_career.global.common.response;

import lombok.Getter;

@Getter
public enum BaseResponseStatus {
	//TODO: 상황에 맞는 메시지 추가해서 사용

	/**
	 * 200xx : OK
	 */
	SUCCESS("success", 20000, "요청에 성공했습니다."),
	LOGIN_SUCCESS("success",20001,"로그인에 성공했습니다."),
	REGISTER_SUCCESS("success",20002,"회원가입에 성공했습니다."),
	CREATE_BOOKMARK_SUCCESS("success", 20003, "북마크 생성에 성공했습니다."),
	DELETE_BOOKMARK_SUCCESS("success", 20004, "북마크 삭제에 성공했습니다."),

	/**
	 * 400xx : Bad Request
	 */
	FAIL("fail", 40000, "요청에 실패했습니다."),
	VALIDATION_ERROR("fail", 40001, "유효성 검사에 실패했습니다."),
	PASSWORD_ERROR("fail", 40002, "유효하지 않은 비밀번호입니다."),
	PASSWORDS_DO_NOT_MATCH("fail", 40003, "비밀번호와 비밀번호 확인이 일치하지 않습니다."),

	/**
	 * 401xx : Unauthorized
	 */
	// JWT Token ERROR
	ACCESSTOKEN_EXPIRED("fail", 40101, "유효하지 않은 Access Token입니다."),
	REFRESHTOKEN_EXPIRED("fail", 40102, "유효하지 않은 Refresh Token입니다."),
	UNSUPPORTED_TOKEN("fail", 40103, "지원하지 않는 Token 입니다."),
	WRONG_TYPE_TOKEN("fail", 40104, "시그니처 검증에 실패한 Token 입니다."),
	DAMAGED_TOKEN("fail", 40105, "손상된 Token 입니다."),

	/**
	 * 404xx : Not Found
	 */
	//User
	USER_NOT_EXIST("fail", 40401, "존재하지 않는 회원입니다."),
	POINT_NOT_EXIST("fail", 40402, "존재하지 않는 포인트 활동입니다."),
	RECRUIT_NOT_EXIST("fail", 40403, "존재하지 않는 교내 추천 채용입니다."),
	POINT_BOOKMARK_NOT_EXIST("fail", 40404, "존재하지 않는 포인트 활동 북마크 입니다."),
	RECRUIT_BOOKMARK_NOT_EXIST("fail", 40405, "존재하지 않는 교내 추천 채용 북마크 입니다."),

	/**
	 * 409xx : Conflict
	 */
	DUPLICATE_EMAIL("fail", 40901, "이미 존재하는 이메일입니다."),
	DUPLICATE_LOGIN_ID("fail", 40902, "이미 존재하는 로그인 아이디입니다.");

	private final String status;
	private final int code;
	private final String message;

	BaseResponseStatus(String status, int code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
}
