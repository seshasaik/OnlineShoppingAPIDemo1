package com.onlineShoping.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineShoping.demo.entity.Inventory;

@RestController
@RequestMapping(path = {"/api/inventory"})
public class InventoryController {

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
