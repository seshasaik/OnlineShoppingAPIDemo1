package com.onlineShoping.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.onlineShoping.demo.util.PurchaseOrderStatus;

@Document
public class PurchaseOrder {

	@Id
	private String id;

	private String purchaseOrderCode;

	private LocalDateTime cratedDate = LocalDateTime.now();

	private PurchaseOrderStatus status;

	private Double worth;

	
	
	private String userName;

	private List<PurchaseOrderItem> items;

	private Supplier supplier;

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



	public LocalDateTime getCratedDate() {
		return cratedDate;
	}

	public void setCratedDate(LocalDateTime cratedDate) {
		this.cratedDate = cratedDate;
	}

	public PurchaseOrderStatus getStatus() {
		return status;
	}

	public void setStatus(PurchaseOrderStatus status) {
		this.status = status;
	}

	public Double getWorth() {
		return worth;
	}

	public void setWorth(Double worth) {
		this.worth = worth;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<PurchaseOrderItem> getItems() {
		return items;
	}

	public void setItems(List<PurchaseOrderItem> items) {
		this.items = items;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	

}
