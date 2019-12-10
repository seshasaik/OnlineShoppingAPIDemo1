package com.onlineShoping.demo.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.onlineShoping.demo.util.OrderStatus;

@Document
public class Order {

	private String number;
	private LocalDate ordered;
	private LocalDate shipped;
	private String shipedTo;
	private OrderStatus status;
	private Double total;

	@DBRef
	private List<LineItem> items;

	@DBRef
	private List<Payment> payments;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public LocalDate getOrdered() {
		return ordered;
	}

	public void setOrdered(LocalDate ordered) {
		this.ordered = ordered;
	}

	public LocalDate getShipped() {
		return shipped;
	}

	public void setShipped(LocalDate shipped) {
		this.shipped = shipped;
	}

	public String getShipedTo() {
		return shipedTo;
	}

	public void setShipedTo(String shipedTo) {
		this.shipedTo = shipedTo;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<LineItem> getItems() {
		return items;
	}

	public void setItems(List<LineItem> items) {
		this.items = items;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

}
