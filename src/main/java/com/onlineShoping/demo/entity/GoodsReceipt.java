package com.onlineShoping.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "goodsReceiptNotes")
public class GoodsReceipt {
	
	public GoodsReceipt() {
		this.createdOn = LocalDateTime.now();
	}

	@Id
	private String id;

	@Indexed(background = true, direction = IndexDirection.DESCENDING, unique = true)
	private String GRNCode;

	@DBRef(lazy = true)
	private PurchaseOrder purchaseOrder;

	private Double worth;

	private List<PurchaseOrderItem> goodsReceiptItems;

	private LocalDateTime createdOn;

	private String receivedUser;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGRNCode() {
		return GRNCode;
	}

	public void setGRNCode(String gRNCode) {
		GRNCode = gRNCode;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public Double getWorth() {
		return worth;
	}

	public void setWorth(Double worth) {
		this.worth = worth;
	}

	public List<PurchaseOrderItem> getGoodsReceiptItems() {
		return goodsReceiptItems;
	}

	public void setGoodsReceiptItems(
			List<PurchaseOrderItem> goodsReceiptItems) {
		this.goodsReceiptItems = goodsReceiptItems;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public String getReceivedUser() {
		return receivedUser;
	}

	public void setReceivedUser(String receivedUser) {
		this.receivedUser = receivedUser;
	}

}
