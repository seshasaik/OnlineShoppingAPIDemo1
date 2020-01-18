package com.onlineShoping.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.onlineShoping.demo.entity.Users;
import com.onlineShoping.demo.exceptions.CustomerAlreadyExistedException;
import com.onlineShoping.demo.exceptions.PasswordMismatchException;
import com.onlineShoping.demo.model.User;

public interface UserService extends UserDetailsService {

	void registerUser(User user) throws CustomerAlreadyExistedException;

	Users findByUserId(String userId);
	
	Users profile();
	
	void updateProfile(User user) throws CustomerAlreadyExistedException;
	
	void changePassword(User user) throws PasswordMismatchException;

}
