package com.onlineShoping.demo.entity;

import com.onlineShoping.demo.util.ProductStatus;

public class ProductStock {
	
	private String batchNo;
	
	private long quntity;
	
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

	public long getQuntity() {
		return quntity;
	}

	public void setQuntity(long quntity) {
		this.quntity = quntity;
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
