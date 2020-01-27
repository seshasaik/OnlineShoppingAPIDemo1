package com.onlineShoping.demo.entity;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.onlineShoping.demo.util.ProductOrderStatus;

@Document
public class PurchaseOrder {

	private String id;

	private String purchaseOrderCode;

	private LocalTime cratedDate;

	private ProductOrderStatus status;

	private Double worth;

	private Users user;

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

	public LocalTime getCratedDate() {
		return cratedDate;
	}

	public void setCratedDate(LocalTime cratedDate) {
		this.cratedDate = cratedDate;
	}

	public ProductOrderStatus getStatus() {
		return status;
	}

	public void setStatus(ProductOrderStatus status) {
		this.status = status;
	}

	public Double getWorth() {
		return worth;
	}

	public void setWorth(Double worth) {
		this.worth = worth;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
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

	public class PurchaseOrderItem {

		private Product product;

		private long orderedQty;

		private long receivedQty;

		private long pendingQty;

		private Double cost;

		public PurchaseOrderItem() {

		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public long getOrderedQty() {
			return orderedQty;
		}

		public void setOrderedQty(long orderedQty) {
			this.orderedQty = orderedQty;
		}

		public long getReceivedQty() {
			return receivedQty;
		}

		public void setReceivedQty(long receivedQty) {
			this.receivedQty = receivedQty;
		}

		public long getPendingQty() {
			return pendingQty;
		}

		public void setPendingQty(long pendingQty) {
			this.pendingQty = pendingQty;
		}

		public Double getCost() {
			return cost;
		}

		public void setCost(Double cost) {
			this.cost = cost;
		}

	}

}
