package com.onlineShoping.demo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.onlineShoping.demo.entity.Customer;
import com.onlineShoping.demo.entity.Order;
import com.onlineShoping.demo.entity.Payment;
import com.onlineShoping.demo.entity.ShopingCart;
import com.onlineShoping.demo.exceptions.CustomerAlreadyExistedException;
import com.onlineShoping.demo.model.User;

public interface CustomerService  {

	Customer saveCustomer(Customer customer) throws CustomerAlreadyExistedException;

	void updateCustomer(Customer customer);

	Customer findByCustomerId(String id);

	Customer findByEmail(String email);

	List<Customer> findAllCustomers();

	List<Order> getOrdersByAccount(String cutomerId);

	List<Payment> getPayments(String cutomerId);

	ShopingCart getShopingCart(String customerId);

	List<Customer> searchCustomer(User user);

}
