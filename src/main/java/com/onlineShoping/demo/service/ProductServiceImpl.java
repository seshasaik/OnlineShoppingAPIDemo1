package com.onlineShoping.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.onlineShoping.demo.entity.Product;
import com.onlineShoping.demo.entity.Supplier;
import com.onlineShoping.demo.exceptions.ProductNotFoundException;
import com.onlineShoping.demo.repository.ProductRepository;

@Service

public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}

	@Override
	public void deleteProdcuct(String id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
	}

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll(Sort.by(Order.desc("id")));
	}

	@Override
	public Product findById(String id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElseThrow(() -> {
			return new ProductNotFoundException(String.format("Product not found for given id : %1$s", id));
		});
	}

	@Override
	public void addSupplierToProduct(String id, Supplier supplier) {
		// TODO Auto-generated method stub
		Product product = findById(id);
		product.getSuppliers().add(supplier);
		productRepository.save(product);
	}

	@Override
	public void removeSupplierFromProduct(String id, Supplier supplier) {
		// TODO Auto-generated method stub
		Product product = findById(id);
		product.getSuppliers().remove(supplier);
		productRepository.save(product);
	}

}
