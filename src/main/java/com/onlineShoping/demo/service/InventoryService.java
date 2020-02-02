package com.onlineShoping.demo.service;

import com.onlineShoping.demo.entity.GoodsReceipt;

public interface InventoryService {

	void updateProductQuantity();
	
	void addProductQuantity(GoodsReceipt goodsReceipt);
	
	void getProductQuantity();
	
	void getZeroBasedProductQuantity();

}
