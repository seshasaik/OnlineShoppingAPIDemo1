package com.onlineShoping.demo.service;

import java.util.List;

import com.onlineShoping.demo.entity.Supplier;
import com.onlineShoping.demo.exceptions.SupplierAlreadyExistedException;
import com.onlineShoping.demo.exceptions.SupplierNotFoundException;

public interface SupplierService {

	List<Supplier> getAllSuppliers();
	
	Supplier getSupplierById(String id) throws SupplierNotFoundException;
	
	void saveSupplier(Supplier supplier) throws SupplierAlreadyExistedException;
	
	void updateSupplier(Supplier supplier) throws SupplierNotFoundException;
	
	
}
