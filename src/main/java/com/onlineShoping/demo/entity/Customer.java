package com.onlineShoping.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onlineShoping.demo.util.CustomerGender;
import com.onlineShoping.demo.util.UserState;

@Document(collection = "customer")
public class Customer {

	@Id	
	private String customerId;
	private String address;
	private String phone;
	private String firstName;
	private String middelName;
	private String lastName;
	private CustomerGender gender;

	@Indexed(unique = true, name = "emailIndx")
	private String email;

	@DBRef
	private Account account;

	// public Customer(String address, String phone, String email, Account
	// account) {
	// this.address = address;
	// this.phone = phone;
	// this.email = email;
	// this.account = account;
	// }

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Customer() {
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddelName() {
		return middelName;
	}

	public void setMiddelName(String middelName) {
		this.middelName = middelName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public CustomerGender getGender() {
		return gender;
	}

	public void setGender(CustomerGender gender) {
		this.gender = gender;
	}

}
