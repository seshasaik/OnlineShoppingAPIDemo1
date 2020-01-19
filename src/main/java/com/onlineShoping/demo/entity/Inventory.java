package com.onlineShoping.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.onlineShoping.demo.util.ProductStatus;

@Document
public class Inventory {

	@Id
	private String id;
	@DBRef
	private Product product;
	private ProductStock[] stock;
	private ProductStatus status;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ProductStock[] getStock() {
		return stock;
	}

	public void setStock(ProductStock[] stock) {
		this.stock = stock;
	}

	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}

}
