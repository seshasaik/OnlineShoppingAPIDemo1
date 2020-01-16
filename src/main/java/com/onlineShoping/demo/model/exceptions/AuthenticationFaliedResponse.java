package com.onlineShoping.demo.model.exceptions;

import org.springframework.http.HttpStatus;

public class AuthenticationFaliedResponse extends BaseAPIResponse {

	public AuthenticationFaliedResponse() {
		// TODO Auto-generated constructor stub
		this(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.name(),
				"Invalid credentials");
	}

	public AuthenticationFaliedResponse(String message) {
		this(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.name(),
				message);
		// TODO Auto-generated constructor stub
	}

	public AuthenticationFaliedResponse(int errorCode, String errorStatus,
			String message) {
		super(errorCode, errorStatus, message);
		// TODO Auto-generated constructor stub
	}

}
