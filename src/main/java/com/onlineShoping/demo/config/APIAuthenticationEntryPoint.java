package com.onlineShoping.demo.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onlineShoping.demo.model.exceptions.AuthenticationFaliedResponse;
import com.onlineShoping.demo.model.exceptions.BaseAPIResponse;

@Component
public class APIAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Autowired
	private MappingJackson2HttpMessageConverter springMvcJacksonConverter;

	public APIAuthenticationEntryPoint() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=UTF-8");

		BaseAPIResponse apiAuthFailed = new AuthenticationFaliedResponse(
				HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.name(),
				"Forbiden unauthorized access ");
		String accessDeniedResponse = springMvcJacksonConverter
				.getObjectMapper().writeValueAsString(apiAuthFailed);
		response.sendError(HttpServletResponse.SC_FORBIDDEN,
				accessDeniedResponse);
	}

}
