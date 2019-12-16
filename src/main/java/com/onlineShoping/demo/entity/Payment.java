package com.onlineShoping.demo.entity;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Payment {

	@Id
	private String id;
	private LocalDate paid;
	private Double total;
	private String details;

	@DBRef(lazy = true)
	private Account account;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getPaid() {
		return paid;
	}

	public void setPaid(LocalDate paid) {
		this.paid = paid;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
