package com.onlineShoping.demo.entity;

public class PurchaseOrderItem {

	public PurchaseOrderItem() {
		// TODO Auto-generated constructor stub
	}

	private Product product;

	private long orderedQty;

	private long receivedQty;

	private long pendingQty;

	private Double cost;

	private Double total;

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

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

}
