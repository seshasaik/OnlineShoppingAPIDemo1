package com.onlineShoping.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.onlineShoping.demo.util.UserState;

@Document(collection = "webUser")
public class WebUser {

	@Id
	private String id;

	@Indexed(name = "userIdIndx", unique = true)
	private String userId;

	private String password;

	private UserState state;

	@DBRef
	private ShopingCart cart;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserState getState() {
		return state;
	}

	public void setState(UserState state) {
		this.state = state;
	}

	public ShopingCart getCart() {
		return cart;
	}

	public void setCart(ShopingCart cart) {
		this.cart = cart;
	}

	public WebUser(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

}
