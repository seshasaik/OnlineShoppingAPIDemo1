package com.onlineShoping.demo.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")
public class Account {

	@Id
//	@Field(name = "accountId")
	private String id;
	private String billingAddress;
	private Boolean accountClosed;
	private LocalDate Open;
	private LocalDate closed;

	private ShopingCart cart;

	@DBRef
	private List<Order> orders = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Boolean getAccountClosed() {
		return accountClosed;
	}

	public void setAccountClosed(Boolean accountClosed) {
		this.accountClosed = accountClosed;
	}

	public LocalDate getOpen() {
		return Open;
	}

	public void setOpen(LocalDate open) {
		Open = open;
	}

	public LocalDate getClosed() {
		return closed;
	}

	public void setClosed(LocalDate closed) {
		this.closed = closed;
	}

	public ShopingCart getCart() {
		return cart;
	}

	public void setCart(ShopingCart cart) {
		this.cart = cart;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Account() {
	}

}
