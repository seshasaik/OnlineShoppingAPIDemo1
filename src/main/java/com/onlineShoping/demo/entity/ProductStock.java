package com.onlineShoping.demo.entity;

import com.onlineShoping.demo.util.ProductStatus;

public class ProductStock {
	
	private String batchNo;
	
	private long quantity;
	
	private Double mrp;
	
	private ProductStatus status;

	public ProductStock() {
		// TODO Auto-generated constructor stub
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}



	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public Double getMrp() {
		return mrp;
	}

	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}

	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}
	
	
	

}
