package com.onlineShoping.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlineShoping.demo.entity.Users;
import com.onlineShoping.demo.service.UserService;

@RequestMapping(path = "/api")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	public UserController() {
		// TODO Auto-generated constructor stub
	}

	@PostMapping(path = {"/login"})
	public void getCustomersByUserId(@RequestBody Users user) {
		Users userInDB = (Users) userService
				.loadUserByUsername(user.getUsername());
		
		

	}

}
