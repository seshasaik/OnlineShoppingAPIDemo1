package com.onlineShoping.demo.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ShopingCart {

	private LocalDate created;

	private List<LineItem> items = new ArrayList<>();

	public LocalDate getCreated() {
		return created;
	}

	public void setCreated(LocalDate created) {
		this.created = created;
	}

	public List<LineItem> getItems() {
		return items;
	}

	public void setItems(List<LineItem> items) {
		this.items = items;
	}

}
