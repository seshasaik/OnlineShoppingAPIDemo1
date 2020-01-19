package com.onlineShoping.demo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.onlineShoping.demo.util.ProductStatus;

@Document
public class Product {

	@Id
	private String id;
	private String name;
	private String description;
	private List<ProductFeature> features;
	private List<Supplier> suppliers;
	private ProductStatus status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public List<ProductFeature> getFeatures() {
		return features;
	}

	public void setFeatures(List<ProductFeature> features) {
		this.features = features;
	}

	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}

}
