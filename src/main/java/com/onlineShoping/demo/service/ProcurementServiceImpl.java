/**
 * 
 */
package com.onlineShoping.demo.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.mongodb.internal.connection.ConcurrentPool.Prune;
import com.onlineShoping.demo.entity.GoodsReceipt;
import com.onlineShoping.demo.entity.PurchaseOrder;
import com.onlineShoping.demo.entity.Users;
import com.onlineShoping.demo.exceptions.PurchaseOrderDeleteConstraintFailedException;
import com.onlineShoping.demo.exceptions.PurchaseOrderNotFoundException;
import com.onlineShoping.demo.model.GoodsReceiptNotesModel;
import com.onlineShoping.demo.model.PurchaseOrderModal;
import com.onlineShoping.demo.repository.GRNRepository;
import com.onlineShoping.demo.repository.PurchaseOrderRepository;
import com.onlineShoping.demo.util.CurrentLoginUser;
import com.onlineShoping.demo.util.PurchaseOrderStatus;

/**
 * @author HOME
 *
 */
@Service
public class ProcurementServiceImpl implements ProcurementService {

	private final String PURCHASE_ORDER_NOT_FOUND_MSG = "Purchaser order not found for given id : %1$s";

	@Autowired
	PurchaseOrderRepository purchaseOrderRepository;

	@Autowired
	SupplierService supplierService;

	@Autowired
	GRNRepository GRNRepository;

	@Override
	public void createPurchaseOrder(PurchaseOrderModal purchaseOrderModal) {

		Users user = (Users) CurrentLoginUser.getUser();

		PurchaseOrder purchaseOrder = new PurchaseOrder();

		BeanUtils.copyProperties(purchaseOrderModal, purchaseOrder);
		purchaseOrder.setCratedDate(LocalDateTime.now());
		purchaseOrder.setUserName(user.getUsername());
		purchaseOrder.setSupplier(this.supplierService
				.getSupplierById(purchaseOrderModal.getSupplierId()));
		purchaseOrder.setStatus(PurchaseOrderStatus.PENDING);

		// TODO Auto-generated method stub
		purchaseOrderRepository.save(purchaseOrder);
	}

	@Override
	public void updatePurchaserOrder(String purchaseOrderId,
			PurchaseOrder purchaseOrder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePurchaseOrder(String purchaseorderId)
			throws PurchaseOrderDeleteConstraintFailedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void createGoodsReceipt(GoodsReceiptNotesModel goodsReceiptNotes) {
		// TODO Auto-generated method stub
		GoodsReceipt gr = new GoodsReceipt();
		BeanUtils.copyProperties(goodsReceiptNotes, gr, "createdOn");
		Users user = (Users) CurrentLoginUser.getUser();
		gr.setReceivedUser(user.getUsername());
		this.GRNRepository.save(gr);
	}

	@Override
	public void updateGoodsReceipt(GoodsReceiptNotesModel goodsReceiptNotes) {
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

		return purchaseOrderRepository.findAllExcludeItems();
	}

	@Override
	public List<PurchaseOrder> findAllPendingPurchaseOrders() {
		// TODO Auto-generated method stub
		return purchaseOrderRepository.findAllPendingOrdersExcludeItems();
	}

	@Override
	public PurchaseOrder findPurchaseOrderById(String id) {
		// TODO Auto-generated method stub
		return purchaseOrderRepository.findById(id).orElseThrow(() -> {
			throw new PurchaseOrderNotFoundException(
					String.format(this.PURCHASE_ORDER_NOT_FOUND_MSG, id));
		});
	}

	@Override
	public List<GoodsReceipt> findAllGoodsReceiptsExcludeItemAndPurchaseOrder() {
		// TODO Auto-generated method stub
		return GRNRepository.findAllGRNExculdingItems();
	}

}
