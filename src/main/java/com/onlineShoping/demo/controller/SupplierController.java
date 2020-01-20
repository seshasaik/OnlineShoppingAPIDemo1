package com.onlineShoping.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onlineShoping.demo.entity.Supplier;
import com.onlineShoping.demo.service.SupplierService;

@RestController
@RequestMapping(path = {"/supplier"})
public class SupplierController {

	@Autowired
	SupplierService supplierService;

	public SupplierController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping
	public List<Supplier> getAllSuppliers() {
		return supplierService.getAllSuppliers();
	}

	@PostMapping(produces = {MediaType.TEXT_PLAIN_VALUE})
	@ResponseStatus(value = HttpStatus.CREATED)
	public void addSupplier(@RequestBody Supplier supplier) {
		supplierService.saveSupplier(supplier);
	}

	@PutMapping
	public void updateSupplier(@RequestBody Supplier supplier) {

	}

}
