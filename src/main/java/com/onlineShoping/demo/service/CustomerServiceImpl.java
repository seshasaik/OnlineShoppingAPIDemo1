package com.onlineShoping.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineShoping.demo.entity.Account;
import com.onlineShoping.demo.entity.Customer;
import com.onlineShoping.demo.entity.GoodsOrder;
import com.onlineShoping.demo.entity.LineItem;
import com.onlineShoping.demo.entity.Payment;
import com.onlineShoping.demo.entity.ShopingCart;
import com.onlineShoping.demo.exceptions.CartUnderFlowException;
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
	private final String CART_UNDER_FLOW_MSG = "Invalid Operation : There is no items in cart to remove";

	@Override
	@Transactional(rollbackFor = {CustomerAlreadyExistedException.class})
	public Customer saveCustomer(Customer customer)
			throws CustomerAlreadyExistedException {

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
	public void updateCustomer(Customer customer)
			throws CustomerAlreadyExistedException {

		if (Objects.isNull(customerRepository.findByEmailAndCustomerIdNot(
				customer.getEmail(), customer.getCustomerId()).orElse(null))) {
			accountService.updateAccount(customer.getAccount());
			customerRepository.save(customer);

		} else {
			throw new CustomerAlreadyExistedException(
					String.format(EMAIL_EXISTED_MSG, customer.getEmail()));
		}

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
	public List<GoodsOrder> getOrdersByAccount(String cutomerId) {
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
	public void addProductToCart(String customerId, LineItem lineItem) {
		// TODO Auto-generated method stub
		Account account = findByCustomerId(customerId).getAccount();
		ShopingCart cart = account.getCart();

		if (cart.getItems().isEmpty()) {
			cart.setCreated(LocalDate.now());
		}

		cart.getItems().add(lineItem);
		accountService.updateAccount(account);

	}

	@Override
	public void removeProductFromCart(String customerId, LineItem lineItem) {
		// TODO Auto-generated method stub
		Account account = findByCustomerId(customerId).getAccount();
		ShopingCart cart = account.getCart();
		if (cart.getItems().isEmpty()) {
			throw new CartUnderFlowException(this.CART_UNDER_FLOW_MSG);
		}
		cart.getItems().remove(lineItem);
		accountService.updateAccount(account);
	}

	@Override
	public void updateProdctQuantityInCart(String customerId,
			LineItem lineItem) {
		Account account = findByCustomerId(customerId).getAccount();
		ShopingCart cart = account.getCart();

		if (cart.getItems().isEmpty()) {
			throw new CartUnderFlowException(this.CART_UNDER_FLOW_MSG);
		}

		cart.setItems(cart.getItems().stream().map(item -> {
			if (item.getId().equals(lineItem.getId())) {
				item.setQuantity(lineItem.getQuantity());
			}
			return item;
		}).collect(Collectors.toList()));
		accountService.updateAccount(account);

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

	private void checkCustomerConstraints(Customer customer)
			throws CustomerAlreadyExistedException {

	}

}
