package com.onlineShoping.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineShoping.demo.entity.Account;
import com.onlineShoping.demo.entity.Customer;
import com.onlineShoping.demo.exceptions.CustomerAlreadyExistedException;
import com.onlineShoping.demo.model.User;
import com.onlineShoping.demo.service.CustomerService;
import com.onlineShoping.demo.util.UserState;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@GetMapping
	public List<Customer> getCustomers() {
		return customerService.findAllCustomers();
	}
	
	@GetMapping(path = "/{customerId}")
	public Customer findCustomerById(@PathVariable String customerId) {
		return customerService.findByCustomerId(customerId);	
	}


	@PostMapping(path = { "/login" })
	public Customer getCustomersByUserId(@RequestBody User user) {
		Customer customer = customerService.findByEmail(user.getEmail());
		return customer;
	}

	
	@PostMapping(path = { "/search" })
	public Customer searchCustomer(@RequestBody User user) {
		Customer customer = customerService.findByEmail(user.getEmail());
		return customer;
	}
	
	@PostMapping
	public ResponseEntity<String> createCustomer(@RequestBody User user) throws CustomerAlreadyExistedException {
		Account account = new Account();
		account.setBillingAddress(user.getBillingAddress());
		Customer customer = new Customer();
		customer.setAddress(user.getAddress());
		customer.setAccount(account);
		customer.setPhone(user.getPhone());
		customer.setEmail(user.getEmail());
		customer.setFirstName(user.getFirstName());
		customer.setLastName(user.getLastName());
		customer.setMiddelName(user.getMiddelName());
		customer.setGender(user.getGender());
//		if (user.isSelfRegistration() && StringUtils.hasText(user.getPassword())) {
//			customer.setPassword(user.getPassword());
//			customer.setState(UserState.ACTIVE);
//		} else {
//			if (user.isSelfRegistration())
//				return new ResponseEntity<String>("Password should not be empty", HttpStatus.BAD_REQUEST);
//		}
		customer = customerService.saveCustomer(customer);
		return new ResponseEntity<String>("Customer created successfully", HttpStatus.OK);

	}

	@PutMapping(path = "/{customerId}")
	public ResponseEntity<String> updateCustomer(@PathVariable String customerId, @RequestBody Customer customer) {
		customerService.updateCustomer(customer);
		return new ResponseEntity<String>("Customer updated successfully", HttpStatus.OK);
	}

	@ExceptionHandler(value = CustomerAlreadyExistedException.class)
	public ResponseEntity<String> customerAlreadyExistedException(CustomerAlreadyExistedException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
	}

}
