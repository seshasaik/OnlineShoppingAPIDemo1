package com.onlineShoping.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineShoping.demo.entity.Product;
import com.onlineShoping.demo.entity.Supplier;
import com.onlineShoping.demo.exceptions.ProductNotFoundException;
import com.onlineShoping.demo.service.ProductService;

@RestController
@RequestMapping(path = "/product")
public class ProductCotroller {

	@Autowired
	ProductService productService;

	@GetMapping
	public List<Product> getAllProducts() {
		return productService.findAllProducts();
	}

	@PostMapping
	public ResponseEntity<String> addProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		return new ResponseEntity<String>("Product added successfully", HttpStatus.OK);
	}

	@DeleteMapping(path = "/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable String productId) {
		productService.deleteProdcuct(productId);
		return new ResponseEntity<String>(String.format("Product %1$s deleted successfully", ""), HttpStatus.OK);
	}

	@PutMapping(path = "/{productId}")
	public ResponseEntity<String> updateProduct(@RequestBody Product product, @PathVariable String productId) {
		productService.updateProduct(product);
		return new ResponseEntity<String>(String.format("Product %1$s updated successfully", ""), HttpStatus.OK);
	}

	@GetMapping(path = "/{productId}/suppliers")
	public List<Supplier> getSupplierByProductId(@PathVariable String productId) {
		return null;
	}

	@PostMapping(path = "/{productId}/supplier")
	public ResponseEntity<String> addSupplier(@RequestBody Supplier supplier, @PathVariable String productId) {
		return new ResponseEntity<String>(String.format("Supplier %1$s added to product %2$s successfully", "", ""),
				HttpStatus.OK);
	}

	@DeleteMapping(path = "/{productId}/supplier")
	public ResponseEntity<String> removeSupplier(@RequestBody Supplier supplier, @PathVariable String productId) {
		return new ResponseEntity<String>(String.format("Supplier %1$s removed from product %2$s successfully", "", ""),
				HttpStatus.OK);
	}

	@ExceptionHandler
	public ResponseEntity<String> productNotFoundExceptionHandler(ProductNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

}
