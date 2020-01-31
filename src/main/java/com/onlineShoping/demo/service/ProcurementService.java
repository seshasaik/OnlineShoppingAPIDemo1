package com.onlineShoping.demo.service;

import java.util.List;

import com.onlineShoping.demo.entity.GoodsReceipt;
import com.onlineShoping.demo.entity.PurchaseOrder;
import com.onlineShoping.demo.exceptions.PurchaseOrderDeleteConstraintFailedException;
import com.onlineShoping.demo.model.GoodsReceiptNotesModel;
import com.onlineShoping.demo.model.PurchaseOrderModal;

public interface ProcurementService {

	void createPurchaseOrder(PurchaseOrderModal purchaseOrder);

	void updatePurchaserOrder(String purchaseOrderId, PurchaseOrder purchaseOrder);
	
	void deletePurchaseOrder(String purchaseorderId) throws PurchaseOrderDeleteConstraintFailedException;

	void createGoodsReceipt(GoodsReceiptNotesModel goodsReceiptNotes);

	void updateGoodsReceipt(GoodsReceiptNotesModel goodsReceiptNotes);

	void createGoodsReturn();

	void upateGoodsReturn();

	List<PurchaseOrder> findAllPurchaseOrders();
	
	PurchaseOrder findPurchaseOrderById(String id);
	
	List<PurchaseOrder> findAllPendingPurchaseOrders();
	
	List<GoodsReceipt> findAllGoodsReceiptsExcludeItemAndPurchaseOrder();

}
