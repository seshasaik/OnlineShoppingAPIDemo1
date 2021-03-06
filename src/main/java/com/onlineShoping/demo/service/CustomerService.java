package com.onlineShoping.demo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.onlineShoping.demo.entity.Customer;
import com.onlineShoping.demo.entity.GoodsOrder;
import com.onlineShoping.demo.entity.LineItem;
import com.onlineShoping.demo.entity.Payment;
import com.onlineShoping.demo.entity.ShopingCart;
import com.onlineShoping.demo.exceptions.CustomerAlreadyExistedException;
import com.onlineShoping.demo.model.User;

public interface CustomerService {

	Customer saveCustomer(Customer customer)
			throws CustomerAlreadyExistedException;

	void updateCustomer(Customer customer)
			throws CustomerAlreadyExistedException;

	Customer findByCustomerId(String id);

	Customer findByEmail(String email);

	Customer findByPhone(String phone);

	List<Customer> findAllCustomers();

	List<GoodsOrder> getOrdersByAccount(String cutomerId);

	List<Payment> getPayments(String cutomerId);

	ShopingCart getShopingCart(String customerId);

	void addProductToCart(String customerId, LineItem lineItem);
	
	void removeProductFromCart(String customerId, LineItem lineItem);

	void updateProdctQuantityInCart(String customerId, LineItem lineItem);

	List<Customer> searchCustomer(User user);

}
