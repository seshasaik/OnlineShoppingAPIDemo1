package com.onlineShoping.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineShoping.demo.entity.Customer;
import com.onlineShoping.demo.entity.WebUser;
import com.onlineShoping.demo.exceptions.CustomerAlreadyExistedException;
import com.onlineShoping.demo.model.User;
import com.onlineShoping.demo.repository.WebUserRepository;
import com.onlineShoping.demo.util.UserState;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	WebUserRepository webUserRepository;

	@Autowired
	CustomerService customerService;

	@Override
	public WebUser findUser(WebUser webUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackFor = { Exception.class })
	public void createUser(User user) throws Exception {
		// TODO Auto-generated method stub

//		Optional<WebUser> userWithSameLoginId = Optional.ofNullable(webUserRepository.findByLoginId(user.getLoginId()));
		WebUser webUser = new WebUser(user.getLoginId(), user.getPassword());
		webUser.setState(UserState.Active);
		try {
			webUserRepository.save(webUser);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException(
					String.format("User is alredy existed with given user id :%1$s", user.getLoginId()));
		}
		Customer customer = new Customer(user.getAddress(), user.getPhone(), user.getEmail(), null);
		customer = customerService.saveCustomer(customer);

		webUserRepository.save(webUser);

	}

	@Override
	public void registerUser(WebUser webUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePassword(WebUser webUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUserStatus(String userId, UserState state) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUserCustomerDetail(String userId, Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public WebUser getUserCustomerDetailsById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public WebUser getShopingCartById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
