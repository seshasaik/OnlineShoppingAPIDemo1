package com.onlineShoping.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineShoping.demo.entity.PurchaseOrder;
import com.onlineShoping.demo.service.ProcurementService;

@RestController
@RequestMapping(path = { "/api/procurement" })
public class ProcurementController {

	@Autowired
	ProcurementService procurementService;

	@GetMapping(path = { "/purchaseOrders" })
	public List<PurchaseOrder> getAllPurchaseOrders() {
		return procurementService.findAllPurchaseOrders();
	}

	@GetMapping(path = { "/purchaseOrders/pending" })
	public List<PurchaseOrder> getAllPendingPurchaseOrders() {
		return procurementService.findAllPendingPurchaseOrders();
	}

	@PostMapping(path = { "/purchaseOrder/create" })
	public void createPurchaseOrders(@RequestBody PurchaseOrder order) {
		procurementService.createPurchaseOrder(order);
	}

	@PutMapping(path = { "/purchaseOrder/update/{id}" })
	public void updatePurchaseOrders(@PathVariable("id") String id, @RequestBody PurchaseOrder order) {
		procurementService.updatePurchaserOrder(id, order);
	}

	@DeleteMapping(path = { "/purchaseOrder/delete/{id}" })
	public void deletePurchaseOrders(@PathVariable("id") String id) {
		procurementService.deletePurchaseOrder(id);
	}

}
