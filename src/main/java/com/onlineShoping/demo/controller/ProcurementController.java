package com.onlineShoping.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onlineShoping.demo.entity.GoodsReceipt;
import com.onlineShoping.demo.entity.PurchaseOrder;
import com.onlineShoping.demo.exceptions.PurchaseOrderNotFoundException;
import com.onlineShoping.demo.model.GoodsReceiptNotesModel;
import com.onlineShoping.demo.model.PurchaseOrderModal;
import com.onlineShoping.demo.model.exceptions.BaseAPIResponse;
import com.onlineShoping.demo.model.exceptions.ErrorAPIResponse;
import com.onlineShoping.demo.service.ProcurementService;

@RestController
@RequestMapping(path = {"/api/procurement"})
public class ProcurementController {

	@Autowired
	ProcurementService procurementService;

	@GetMapping(path = {"/purchaseOrders"})
	public List<PurchaseOrder> getAllPurchaseOrders() {
		List<PurchaseOrder> purchaseOrderList = procurementService
				.findAllPurchaseOrders();
		return purchaseOrderList;
	}

	@GetMapping(path = {"/purchaseOrders/{id}"})
	public PurchaseOrder getAllPurchaseOrderById(
			@PathVariable(name = "id") String id) {

		PurchaseOrder purchaseOrderList = procurementService
				.findPurchaseOrderById(id);
		return purchaseOrderList;
	}

	@GetMapping(path = {"/purchaseOrders/pending"})
	public List<PurchaseOrder> getAllPendingPurchaseOrders() {
		return procurementService.findAllPendingPurchaseOrders();
	}

	@PostMapping(path = {"/purchaseOrder/create"})
	@ResponseStatus(value = HttpStatus.CREATED)
	public void createPurchaseOrders(@RequestBody PurchaseOrderModal order) {
		procurementService.createPurchaseOrder(order);
	}

	@PutMapping(path = {"/purchaseOrder/update/{id}"})
	public void updatePurchaseOrders(@PathVariable("id") String id,
			@RequestBody PurchaseOrder order) {
		procurementService.updatePurchaserOrder(id, order);
	}

	@DeleteMapping(path = {"/purchaseOrder/delete/{id}"})
	public void deletePurchaseOrders(@PathVariable("id") String id) {
		procurementService.deletePurchaseOrder(id);
	}

	@PostMapping(path = {"/GRN/create"})
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createGRN(
			@RequestBody GoodsReceiptNotesModel goodsReceiptNotes) {
		this.procurementService.createGoodsReceipt(goodsReceiptNotes);
	}

	@GetMapping(path = {"/GRN"})
	public List<GoodsReceipt> getGRNExcludeItemAndPurchaseOrder() {
		return this.procurementService
				.findAllGoodsReceiptsExcludeItemAndPurchaseOrder();
	}

	@ExceptionHandler(value = {PurchaseOrderNotFoundException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public BaseAPIResponse handlePurchaseOrderNotFoundException(
			PurchaseOrderNotFoundException ex) {
		return new ErrorAPIResponse(HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.name(), ex.getMessage());
	}

}
