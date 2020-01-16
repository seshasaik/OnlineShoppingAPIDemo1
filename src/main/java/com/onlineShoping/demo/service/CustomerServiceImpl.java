package com.onlineShoping.demo.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineShoping.demo.entity.Account;
import com.onlineShoping.demo.entity.Customer;
import com.onlineShoping.demo.entity.Order;
import com.onlineShoping.demo.entity.Payment;
import com.onlineShoping.demo.entity.ShopingCart;
import com.onlineShoping.demo.exceptions.CustomerAlreadyExistedException;
import com.onlineShoping.demo.exceptions.CustomerNotFoundException;
import com.onlineShoping.demo.model.User;
import com.onlineShoping.demo.repository.CustomerRepository;

@Service

public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountService accountService;

	private final String EMAIL_EXISTED_MSG = "Email \'%1$s\' is alreday existed, please try with another one";
	private final String MOBIL_EXISTED_MSG = "Mobile \'%1$s\' is alreday existed, please try with another one";
	private final String CUSTOMER_NOT_FOUND_MSG = "Customer not found with given %1$s : %2$s";

	@Override
	@Transactional(rollbackFor = {CustomerAlreadyExistedException.class})
	public Customer saveCustomer(Customer customer)
			throws CustomerAlreadyExistedException {
		// TODO Auto-generated method stub

		Customer existedCustomerWithEmail = null;
		Customer existedCustomerWithMobile = null;
		try {
			existedCustomerWithEmail = this.findByEmail(customer.getEmail());
		} catch (CustomerNotFoundException e) {
			// TODO: handle exception
		}
		if (Objects.isNull(existedCustomerWithEmail)) {

			// Check for customer by given mobile nos
			try {
				existedCustomerWithMobile = this
						.findByPhone(customer.getPhone());
			} catch (CustomerNotFoundException e) {
				// TODO: handle exception
			}

			if (Objects.isNull(existedCustomerWithMobile)) {
				Account account = new Account();
				account.setBillingAddress(customer.getAddress());
				customer.setAccount(accountService.createAccount(account));
				return customerRepository.save(customer);

			} else {
				throw new CustomerAlreadyExistedException(
						String.format(MOBIL_EXISTED_MSG, customer.getPhone()));
			}

		} else {
			throw new CustomerAlreadyExistedException(
					String.format(EMAIL_EXISTED_MSG, customer.getEmail()));
		}

		// Optional<Customer> customerWithSameEmail =
		// customerRepository.findByEmail(customer.getEmail());
		// if (customerWithSameEmail.isPresent()) {
		// throw new CustomerAlreadyExistedException(
		// String.format("Customer with the given email : %1$s is already
		// existed", customer.getEmail()));
		// }

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
			return new CustomerNotFoundException(String
					.format("Customer not found with given id : %1$s", id));
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
			return new CustomerNotFoundException(
					String.format(CUSTOMER_NOT_FOUND_MSG, "email", email));
		});
	}

	@Override
	public List<Customer> searchCustomer(User user) {
		// TODO Auto-generated method stub

		return customerRepository.findByPhoneOrEmail(user.getPhone(),
				user.getEmail(), null);
	}

	@Override
	public Customer findByPhone(String phone) {
		// TODO Auto-generated method stub
		return customerRepository.findByPhone(phone).orElseThrow(() -> {
			return new CustomerNotFoundException(
					String.format(CUSTOMER_NOT_FOUND_MSG, "mobile", phone));
		});
	}

}
