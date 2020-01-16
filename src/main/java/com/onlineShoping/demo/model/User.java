package com.onlineShoping.demo.model;

import com.onlineShoping.demo.util.CustomerGender;

public class User {

	private String userName;

	private String password;

	private String oldPassword;

	private String address;

	private String phone;

	private String email;
	private String firstName;
	private String middelName;
	private String lastName;
	private CustomerGender gender;

	private String billingAddress;

	private boolean selfRegistration;

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
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

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public boolean isSelfRegistration() {
		return selfRegistration;
	}

	public void setSelfRegistration(boolean selfRegistration) {
		this.selfRegistration = selfRegistration;
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
