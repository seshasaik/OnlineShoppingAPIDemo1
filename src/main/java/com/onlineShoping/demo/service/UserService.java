package com.onlineShoping.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.onlineShoping.demo.entity.Users;

public interface UserService extends UserDetailsService {
	
	
	
	Users findByUserId(String userId);
}
