package com.onlineShoping.demo.model;

import java.util.List;

import com.onlineShoping.demo.entity.PurchaseOrderItem;

public class GoodsReceiptNotesModel {

	public GoodsReceiptNotesModel() {
		// TODO Auto-generated constructor stub
	}

	private String id;

	private String GRNCode;

	private Double worth;

	private List<PurchaseOrderItem> goodsReceiptItems;

	private String purchaseOrderId;

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

	public String getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(String purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

}
