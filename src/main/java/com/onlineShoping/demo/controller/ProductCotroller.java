package com.onlineShoping.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.onlineShoping.demo.entity.Product;
import com.onlineShoping.demo.entity.Supplier;
import com.onlineShoping.demo.exceptions.ProductNotFoundException;
import com.onlineShoping.demo.exceptions.SupplierAlreadyExistedException;
import com.onlineShoping.demo.exceptions.SupplierNotFoundException;
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
	
	@GetMapping(path = "/supplierId")
	public List<Product> getAllProductsBySupplierId(@RequestParam("supplierId") String supplierId) {
		return productService.findAllProductsBySupplierId(supplierId);
	}

	@PostMapping(produces = {MediaType.TEXT_PLAIN_VALUE})
	@ResponseStatus(value = HttpStatus.CREATED)
	public void addProduct(@RequestBody Product product) {
		productService.saveProduct(product);

	}

	@DeleteMapping(path = "/{productId}")
	public ResponseEntity<String> deleteProduct(
			@PathVariable String productId) {
		productService.deleteProdcuct(productId);
		return new ResponseEntity<String>(
				String.format("Product %1$s deleted successfully", ""),
				HttpStatus.OK);
	}

	@PutMapping(path = "/{productId}")
	public ResponseEntity<String> updateProduct(@RequestBody Product product,
			@PathVariable String productId) {
		productService.updateProduct(product);
		return new ResponseEntity<String>(
				String.format("Product %1$s updated successfully", ""),
				HttpStatus.OK);
	}

	@GetMapping(path = "/{productId}/suppliers")
	public List<Supplier> getSupplierByProductId(
			@PathVariable String productId) {
		return null;
	}

	@PostMapping(path = "/{productId}/supplier")
	public ResponseEntity<String> addSupplier(@RequestBody Supplier supplier,
			@PathVariable String productId) {

		Product product = productService.addSupplierToProduct(productId,
				supplier);
		return new ResponseEntity<String>(String.format(
				"Supplier %1$s added to product %2$s successfully",
				supplier.getName(), product.getName()), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{productId}/supplier")
	public ResponseEntity<String> removeSupplier(@RequestBody Supplier supplier,
			@PathVariable String productId) {
		Product product = productService.removeSupplierFromProduct(productId,
				supplier);
		return new ResponseEntity<String>(String.format(
				"Supplier %1$s removed from product %2$s successfully",
				supplier.getName(), product.getName()), HttpStatus.OK);
	}

	@ExceptionHandler
	public ResponseEntity<String> productNotFoundExceptionHandler(
			ProductNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<String> supplierAlreadyExistedExceptionHandler(
			SupplierAlreadyExistedException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler
	public ResponseEntity<String> supplierNotFoundExceptionHandler(
			SupplierNotFoundException e) {
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
	}
}
