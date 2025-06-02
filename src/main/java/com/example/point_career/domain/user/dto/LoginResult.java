package com.example.point_career.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResult {
	private LoginResponse loginResponse;
	private String accessToken;
	private String refreshToken;
}
