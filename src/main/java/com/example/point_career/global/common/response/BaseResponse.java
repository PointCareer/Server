package com.example.point_career.global.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"status", "code", "message", "result"})
public class BaseResponse<T> {
	private String status;
	private int code;
	private String message;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private T result;


	public BaseResponse(BaseResponseStatus responseStatus) {
		this.status = responseStatus.getStatus();
		this.message = responseStatus.getMessage();
		this.code = responseStatus.getCode();
	}

	public BaseResponse(BaseResponseStatus responseStatus, T result) {
		this.status = responseStatus.getStatus();
		this.message = responseStatus.getMessage();
		this.code = responseStatus.getCode();
		this.result = result;
	}
}
