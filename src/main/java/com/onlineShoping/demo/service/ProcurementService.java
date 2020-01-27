package com.onlineShoping.demo.service;

import java.util.List;

import com.onlineShoping.demo.entity.PurchaseOrder;
import com.onlineShoping.demo.exceptions.PurchaseOrderDeleteConstraintFailedException;

public interface ProcurementService {

	void createPurchaseOrder(PurchaseOrder purchaseOrder);

	void updatePurchaserOrder(String purchaseOrderId, PurchaseOrder purchaseOrder);
	
	void deletePurchaseOrder(String purchaseorderId) throws PurchaseOrderDeleteConstraintFailedException;

	void createGoodsReceipt();

	void updateGoodsReceipt();

	void createGoodsReturn();

	void upateGoodsReturn();

	List<PurchaseOrder> findAllPurchaseOrders();
	
	List<PurchaseOrder> findAllPendingPurchaseOrders();
	
	List<PurchaseOrder> findAllGoodsReceipts();

}
