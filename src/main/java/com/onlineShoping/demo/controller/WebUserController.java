package com.onlineShoping.demo.controller;

import java.util.HashMap;

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
import com.onlineShoping.demo.model.User;
import com.onlineShoping.demo.service.UserService;

@RestController
public class WebUserController {

	@Autowired
	UserService userService;

	@PostMapping(path = { "/login" })
	public void signIn(@RequestBody WebUser user) {

	}

	@PostMapping(path = { "/register" })
	@ResponseStatus(code = HttpStatus.CREATED)
	public void register(@RequestBody User user) throws Exception {
		userService.createUser(user);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> UserAlredyExistedHanlder(Exception e) {
		e.printStackTrace();
		if (e instanceof IllegalArgumentException || e instanceof CustomerAlreadyExistedException)
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);

		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
