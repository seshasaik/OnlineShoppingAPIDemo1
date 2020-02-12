package com.onlineShoping.demo.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.onlineShoping.demo.entity.Product;
import com.onlineShoping.demo.entity.Supplier;

public interface ProductService {

	Product saveProduct(Product product);

	void updateProduct(Product product);

	void deleteProdcuct(String id);

	List<Product> findAllProducts();
	
	List<Product> findAllProducts(int page, int size);
	
	List<Product> findAllProductsBySupplierId(String supplierId);

	Product findById(String id);

	Product addSupplierToProduct(String id, Supplier supplier);

	Product removeSupplierFromProduct(String id, Supplier supplier);

}
