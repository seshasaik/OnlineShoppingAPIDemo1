package com.onlineShoping.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineShoping.demo.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	
	@Autowired
	InventoryRepository inventoryRepository;
	
	public InventoryServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateProductQuantity() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addProductQuantity() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getProductQuantity() {
		// TODO Auto-generated method stub
		inventoryRepository.findAll();
	}

	@Override
	public void getZeroBasedProductQuantity() {
		// TODO Auto-generated method stub

	}

}
