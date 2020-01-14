package com.onlineShoping.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.onlineShoping.demo.entity.Users;
import com.onlineShoping.demo.exceptions.UserNotFoundException;
import com.onlineShoping.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(username).orElseThrow(() -> {
			return new UsernameNotFoundException(String.format("User with given name : %1$s is not found", username));
		});
	}

	@Override
	public Users findByUserId(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElseThrow(() -> {
			return new UserNotFoundException(String.format("User with given id : %1$s is not found", userId));
		});
	}

}
