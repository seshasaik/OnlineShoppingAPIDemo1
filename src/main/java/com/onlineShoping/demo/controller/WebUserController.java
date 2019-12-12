package com.onlineShoping.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onlineShoping.demo.entity.WebUser;
import com.onlineShoping.demo.exceptions.CustomerAlreadyExistedException;
import com.onlineShoping.demo.exceptions.InvalidCredentialException;
import com.onlineShoping.demo.exceptions.UserNotFoundException;
import com.onlineShoping.demo.model.User;
import com.onlineShoping.demo.service.UserService;

@RestController
public class WebUserController {

	@Autowired
	UserService userService;

	@PostMapping(path = { "/login" })
	public ResponseEntity<WebUser> signIn(@RequestBody User user) {
		
		return new ResponseEntity<WebUser>(userService.findUser(user), HttpStatus.OK);
	}

	@PostMapping(path = { "/register" })
	@ResponseStatus(code = HttpStatus.CREATED)
	public void register(@RequestBody User user) throws Exception {
		userService.createUser(user);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> exceptionHanlder(Exception e) {
		e.printStackTrace();
		if (e instanceof IllegalArgumentException || e instanceof CustomerAlreadyExistedException)
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<String> userNotFoundExceptionHanlder(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = InvalidCredentialException.class)
	public ResponseEntity<String> invalidCredentialExceptionHanlder(Exception e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
	}

}
