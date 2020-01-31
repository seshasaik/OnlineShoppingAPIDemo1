package com.onlineShoping.demo.model;

import java.time.LocalTime;
import java.util.List;

import com.onlineShoping.demo.entity.PurchaseOrderItem;

public class PurchaseOrderModal {

	public PurchaseOrderModal() {
		
	}
	
	private String id;

	private String purchaseOrderCode;

	private LocalTime cratedDate;
	
	private Double worth;

	private List<PurchaseOrderItem> items;
	
	private String supplierId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPurchaseOrderCode() {
		return purchaseOrderCode;
	}

	public void setPurchaseOrderCode(String purchaseOrderCode) {
		this.purchaseOrderCode = purchaseOrderCode;
	}

	public LocalTime getCratedDate() {
		return cratedDate;
	}

	public void setCratedDate(LocalTime cratedDate) {
		this.cratedDate = cratedDate;
	}

	public Double getWorth() {
		return worth;
	}

	public void setWorth(Double worth) {
		this.worth = worth;
	}

	public List<PurchaseOrderItem> getItems() {
		return items;
	}

	public void setItems(List<PurchaseOrderItem> items) {
		this.items = items;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	
	

}
