/**
 * 
 */
package com.onlineShoping.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlineShoping.demo.entity.PurchaseOrder;
import com.onlineShoping.demo.exceptions.PurchaseOrderDeleteConstraintFailedException;

/**
 * @author HOME
 *
 */
@Service
public class ProcurementServiceImpl implements ProcurementService {

	@Override
	public void createPurchaseOrder(PurchaseOrder purchaseOrder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePurchaserOrder(String purchaseOrderId, PurchaseOrder purchaseOrder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePurchaseOrder(String purchaseorderId) throws PurchaseOrderDeleteConstraintFailedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void createGoodsReceipt() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateGoodsReceipt() {
		// TODO Auto-generated method stub

	}

	@Override
	public void createGoodsReturn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void upateGoodsReturn() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PurchaseOrder> findAllPurchaseOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PurchaseOrder> findAllPendingPurchaseOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PurchaseOrder> findAllGoodsReceipts() {
		// TODO Auto-generated method stub
		return null;
	}

}
