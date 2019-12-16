package com.onlineShoping.demo.entity;

public class Supplier {

	private String regNumber;
	private String name;
	private String phone;
	private String mobile;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	@Override
	public String toString() {
		return "Supplier [regNumber = " + regNumber + ", name=" + name + ", phone=" + phone + ", mobile=" + mobile
				+ ", address=" + address + "]";
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Supplier other = (Supplier) obj;
		return this.regNumber.equals(other.getRegNumber());
	}

}
