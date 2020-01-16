package com.onlineShoping.demo.model.exceptions;

import org.springframework.http.HttpStatus;

public class CustomerRegistrationFailedErrorResponse
		extends
			BaseAPIResponse {

	public CustomerRegistrationFailedErrorResponse() {
		this("Integrity constrains violence while saving data");
	}

	public CustomerRegistrationFailedErrorResponse(String message) {
		this(HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.name(), message);
	}

	public CustomerRegistrationFailedErrorResponse(int code, String status,
			String message) {
		super(code, status, message);
		// TODO Auto-generated constructor stub
	}

}
