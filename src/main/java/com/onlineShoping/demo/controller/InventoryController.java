package com.onlineShoping.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<Inventory> getInventory() {
		return null;
	}

	public void saveInventory(List<Inventory> inventories) {

	}

	public void updateInventory(List<Inventory> inventories) {

	}

	private List<Inventory> zeroItemInvetory() {
		return null;
	}

}
