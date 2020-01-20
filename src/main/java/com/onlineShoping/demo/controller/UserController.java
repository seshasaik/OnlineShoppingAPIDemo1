package com.onlineShoping.demo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onlineShoping.demo.config.JWTTokenUtil;
import com.onlineShoping.demo.entity.Users;
import com.onlineShoping.demo.exceptions.CustomerAlreadyExistedException;
import com.onlineShoping.demo.exceptions.PasswordMismatchException;
import com.onlineShoping.demo.model.User;
import com.onlineShoping.demo.model.exceptions.AuthenticationFaliedResponse;
import com.onlineShoping.demo.model.exceptions.BaseAPIResponse;
import com.onlineShoping.demo.model.exceptions.CustomerRegistrationFailedErrorResponse;
import com.onlineShoping.demo.model.exceptions.SuccessAPIResponse;
import com.onlineShoping.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private JWTTokenUtil jwtTokenUtil;

	public UserController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping(path = {"/login"})
	public User login(@RequestBody User user) {

		Users userInDB = (Users) userService
				.loadUserByUsername(user.getUserName());
		authManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUserName(),
						user.getPassword(), userInDB.getAuthorities()));

		String token = jwtTokenUtil.generateToken(userInDB);

		BeanUtils.copyProperties(userInDB, user);
		user.setPassword("");
		user.setToken(token);
		return user;

	}

	@PostMapping(path = {"/sign-up"})
	@ResponseStatus(code = HttpStatus.OK)
	public HttpEntity<SuccessAPIResponse> register(@RequestBody User user)
			throws CustomerAlreadyExistedException {
		userService.registerUser(user);
		return new HttpEntity<SuccessAPIResponse>(
				new SuccessAPIResponse("User registration successfully"));
	}

	@GetMapping(path = {"/profile"})
	@ResponseStatus(code = HttpStatus.OK)
	public User profile() {

		Users user = userService.profile();
		User usr = new User();
		BeanUtils.copyProperties(user, usr);
		BeanUtils.copyProperties(user.getCustomer(), usr);
		usr.setPassword(null);

		return usr;
	}

	@PostMapping(path = {"/profile"})
	@ResponseStatus(code = HttpStatus.OK)
	public HttpEntity<SuccessAPIResponse> updateProfile(@RequestBody User user)
			throws CustomerAlreadyExistedException {
		userService.updateProfile(user);
		return new HttpEntity<SuccessAPIResponse>(
				new SuccessAPIResponse("Profile saved successfully"));
	}

	@PostMapping(path = {"/change-password"})
	@ResponseStatus(code = HttpStatus.OK)
	public HttpEntity<SuccessAPIResponse> changePassword(@RequestBody User user)
			throws CustomerAlreadyExistedException, PasswordMismatchException {
		userService.changePassword(user);
		return new HttpEntity<SuccessAPIResponse>(
				new SuccessAPIResponse("Password changed successfully"));
	}

	@ExceptionHandler(value = {UsernameNotFoundException.class,
			AuthenticationException.class})
	public ResponseEntity<BaseAPIResponse> handleAuthenticationFaliedException(
			AuthenticationException e) {
		HttpStatus httpStatus = HttpStatus.FORBIDDEN;

		if (e instanceof DisabledException) {
			return new ResponseEntity<>(
					new AuthenticationFaliedResponse(String.format(
							"Your access is disabled, please contact admin")),
					httpStatus);
		} else if (e instanceof UsernameNotFoundException
				| e instanceof BadCredentialsException) {
			httpStatus = HttpStatus.NOT_FOUND;
			return new ResponseEntity<>(
					new AuthenticationFaliedResponse(httpStatus.value(),
							httpStatus.name(), e.getMessage()),
					httpStatus);
		}

		else {
			return new ResponseEntity<>(new AuthenticationFaliedResponse(),
					httpStatus);
		}

	}

	@ExceptionHandler(value = {PasswordMismatchException.class})
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public BaseAPIResponse handlePasswordMismatchException(
			PasswordMismatchException e) {

		return new AuthenticationFaliedResponse(e.getMessage());

	}

	@ExceptionHandler(value = {CustomerAlreadyExistedException.class})
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public BaseAPIResponse handleCustomerAlreadyExistedException(
			CustomerAlreadyExistedException e) {
		return new CustomerRegistrationFailedErrorResponse(e.getMessage());
	}

	@ExceptionHandler(value = {DataIntegrityViolationException.class})
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public BaseAPIResponse handleDataIntegrityViolationException(
			DataIntegrityViolationException e) {
		return new CustomerRegistrationFailedErrorResponse();
	}

}
