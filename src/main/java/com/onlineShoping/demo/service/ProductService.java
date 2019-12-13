package com.onlineShoping.demo.service;

import java.util.List;

import com.onlineShoping.demo.entity.Product;
import com.onlineShoping.demo.entity.Supplier;

public interface ProductService {

	Product saveProduct(Product product);

	void updateProduct(Product product);

	void deleteProdcuct(String id);

	List<Product> findAllProducts();

	Product findById(String id);

	Product addSupplierToProduct(String id, Supplier supplier);

	Product removeSupplierFromProduct(String id, Supplier supplier);

}
