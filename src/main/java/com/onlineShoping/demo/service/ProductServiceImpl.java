package com.onlineShoping.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.onlineShoping.demo.entity.Product;
import com.onlineShoping.demo.entity.Supplier;
import com.onlineShoping.demo.exceptions.ProductNotFoundException;
import com.onlineShoping.demo.exceptions.SupplierAlreadyExistedException;
import com.onlineShoping.demo.exceptions.SupplierNotFoundException;
import com.onlineShoping.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub

		if (Objects.isNull(product.getSuppliers()))
			product.setSuppliers(new ArrayList<Supplier>());
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
		Sort sort = Sort.by(Order.desc("id"));
		return productRepository.findAll(sort);
	}

	@Override
	public List<Product> findAllProducts(int page, int size) {
		// TODO Auto-generated method stub
		final Pageable pagebale = PageRequest.of(page, size,
				Sort.by(Order.by("id")));
		Page<Product> currentPage = productRepository.findAll(pagebale);
		return currentPage.getContent();

	}

	@Override
	public List<Product> findAllProductsBySupplierId(String supplierId) {
		// TODO Auto-generated method stub
		return productRepository.findSuppliersById(supplierId);
	}

	@Override
	public Product findById(String id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).orElseThrow(() -> {
			return new ProductNotFoundException(
					String.format("Product not found for given id : %1$s", id));
		});
	}

	@Override
	public Product addSupplierToProduct(String id, Supplier supplier) {
		// TODO Auto-generated method stub
		Product product = findById(id);
		List<Supplier> suppliers = product.getSuppliers();
		if (suppliers.contains(supplier)) {
			throw new SupplierAlreadyExistedException(String.format(
					"Supplier %1$s with Registed number %2$s is existed in product %3$s",
					supplier.getName(), supplier.getRegNumber(),
					product.getName()));
		}
		suppliers.add(supplier);
		productRepository.save(product);
		return product;
	}

	@Override
	public Product removeSupplierFromProduct(String id, Supplier supplier) {
		// TODO Auto-generated method stub
		Product product = findById(id);
		if (!product.getSuppliers().remove(supplier)) {
			throw new SupplierNotFoundException(String.format(
					"Supplier %1$s with Registed number %2$s is not found in product %3$s",
					supplier.getName(), supplier.getRegNumber(),
					product.getName()));
		}

		productRepository.save(product);
		return product;
	}

}
