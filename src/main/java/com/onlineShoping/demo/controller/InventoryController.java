package com.onlineShoping.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineShoping.demo.entity.Inventory;
import com.onlineShoping.demo.service.InventoryService;

@RestController
@RequestMapping(path = { "/api/inventory" })
public class InventoryController {

	@Autowired
	InventoryService inventoryService;

	public InventoryController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping
	public List<Inventory> getInventory() {
		return inventoryService.getProductQuantity();
	}

	

	private List<Inventory> zeroItemInvetory() {
		return null;
	}

}
