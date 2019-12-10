package com.onlineShoping.demo.service;

import com.onlineShoping.demo.entity.Customer;
import com.onlineShoping.demo.entity.WebUser;
import com.onlineShoping.demo.model.User;
import com.onlineShoping.demo.util.UserState;

public interface UserService {

	WebUser findUser(WebUser webUser);

	void createUser(User user) throws Exception;

	void registerUser(WebUser webUser);

	void updatePassword(WebUser webUser);

	void updateUserStatus(String userId, UserState state);

	void updateUserCustomerDetail(String userId, Customer customer);

	WebUser getUserCustomerDetailsById(String userId);

	WebUser getShopingCartById(String userId);

}
