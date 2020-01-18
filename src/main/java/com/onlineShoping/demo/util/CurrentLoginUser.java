package com.onlineShoping.demo.util;

import org.springframework.security.core.context.SecurityContextHolder;

import com.onlineShoping.demo.entity.Users;

public class CurrentLoginUser {

	public static Users getUser() {

		return (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	}
}
