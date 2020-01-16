package com.onlineShoping.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.onlineShoping.demo.entity.Customer;
import com.onlineShoping.demo.entity.Roles;
import com.onlineShoping.demo.entity.Users;
import com.onlineShoping.demo.exceptions.CustomerAlreadyExistedException;
import com.onlineShoping.demo.exceptions.UserNotFoundException;
import com.onlineShoping.demo.model.User;
import com.onlineShoping.demo.repository.RoleRepository;
import com.onlineShoping.demo.repository.UserRepository;
import com.onlineShoping.demo.util.UserRole;
import com.onlineShoping.demo.util.UserState;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	CustomerService customerService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	private final String USER_NAME_EXISTED_MSG = "Username \'%1$s\' is alreday existed, please try with another one";

	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.findByUserName(username).orElseThrow(() -> {
			return new UsernameNotFoundException(String.format(
					"User with given name : %1$s is not found", username));
		});
	}

	@Override
	public Users findByUserId(String userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElseThrow(() -> {
			return new UserNotFoundException(String
					.format("User with given id : %1$s is not found", userId));
		});
	}

	@Override
	public void registerUser(User user) throws CustomerAlreadyExistedException {
		// TODO Auto-generated method stub
		if (!userRepository.findByUserName(user.getUserName()).isPresent()) {

			Customer customer = new Customer();
			BeanUtils.copyProperties(user, customer);
			
			customer = customerService.saveCustomer(customer);

			Users webUser = new Users();
			webUser.setCustomer(customer);
			webUser.setPassword(passwordEncoder.encode(user.getPassword()));
			webUser.setUserName(user.getUserName());
			webUser.setState(UserState.ACTIVE);
			List<Roles> roleList = new ArrayList<Roles>();
			roleList.add(roleRepository.findByName(UserRole.WEB_USER));
			webUser.setRoles(roleList);

			userRepository.save(webUser);

		} else {
			throw new CustomerAlreadyExistedException(
					String.format(USER_NAME_EXISTED_MSG, user.getUserName()));
		}

	}

}
