package com.onlineShoping.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineShoping.demo.entity.Account;
import com.onlineShoping.demo.entity.Customer;
import com.onlineShoping.demo.entity.Order;
import com.onlineShoping.demo.entity.Payment;
import com.onlineShoping.demo.entity.ShopingCart;
import com.onlineShoping.demo.exceptions.CustomerAlreadyExistedException;
import com.onlineShoping.demo.exceptions.CustomerNotFoundException;
import com.onlineShoping.demo.exceptions.UserNotFoundException;
import com.onlineShoping.demo.model.User;
import com.onlineShoping.demo.repository.CustomerRepository;

@Service

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountService accountService;

	@Override
	@Transactional(rollbackFor = { CustomerAlreadyExistedException.class })
	public Customer saveCustomer(Customer customer) throws CustomerAlreadyExistedException {
		// TODO Auto-generated method stub
		Optional<Customer> customerWithSameEmail = customerRepository.findByEmail(customer.getEmail());
		if (customerWithSameEmail.isPresent()) {
			throw new CustomerAlreadyExistedException(
					String.format("Customer with the given email : %1$s is already existed", customer.getEmail()));
		}

		Account account = accountService.createAccount(customer.getAccount());
		customer.setAccount(account);
		return customerRepository.save(customer);
	}

	@Override	
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		this.findByCustomerId(customer.getCustomerId());
		customerRepository.save(customer);
	}

	@Override
	public Customer findByCustomerId(String id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).orElseThrow(() -> {
			return new CustomerNotFoundException(String.format("Customer not found with given id : %1$s", id));
		});
	}

	@Override
	public List<Order> getOrdersByAccount(String cutomerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payment> getPayments(String cutomerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShopingCart getShopingCart(String customerId) {
		// TODO Auto-generated method stub
		return findByCustomerId(customerId).getAccount().getCart();
	}

	@Override
	public List<Customer> findAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer findByEmail(String email) {
		// TODO Auto-generated method stub
		return customerRepository.findByEmail(email).orElseThrow(() -> {
			return new CustomerNotFoundException(String.format("Customer not found with given email : %1$s", email));
		});
	}

	@Override
	public List<Customer> searchCustomer(User user) {
		// TODO Auto-generated method stub

		return customerRepository.findByPhoneOrEmail(user.getPhone(), user.getEmail(), null);
	}



}
