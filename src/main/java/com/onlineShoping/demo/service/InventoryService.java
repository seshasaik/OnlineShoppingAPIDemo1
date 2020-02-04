package com.onlineShoping.demo.service;

import java.util.List;

import com.onlineShoping.demo.entity.GoodsReceipt;
import com.onlineShoping.demo.entity.Inventory;

public interface InventoryService {

	void updateProductQuantity();
	
	void addProductQuantity(GoodsReceipt goodsReceipt);
	
	List<Inventory> getProductQuantity();
	
	void getZeroBasedProductQuantity();

}
