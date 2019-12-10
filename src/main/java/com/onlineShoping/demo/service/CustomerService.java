package com.onlineShoping.demo.service;

import java.util.List;

import com.onlineShoping.demo.entity.Customer;
import com.onlineShoping.demo.entity.Order;
import com.onlineShoping.demo.entity.Payment;
import com.onlineShoping.demo.entity.ShopingCart;
import com.onlineShoping.demo.exceptions.CustomerAlreadyExistedException;

public interface CustomerService {

	Customer saveCustomer(Customer customer) throws CustomerAlreadyExistedException;

	void updateCustomer(Customer customer);

	Customer findById(String id);

	List<Order> getOrdersByAccount(String cutomerId);

	List<Payment> getPayments(String cutomerId);

	ShopingCart getShopingCart(String customerId);

}
