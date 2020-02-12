package com.onlineShoping.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineShoping.demo.entity.LineItem;
import com.onlineShoping.demo.entity.ShopingCart;
import com.onlineShoping.demo.exceptions.CartUnderFlowException;
import com.onlineShoping.demo.model.exceptions.BaseAPIResponse;
import com.onlineShoping.demo.model.exceptions.ErrorAPIResponse;
import com.onlineShoping.demo.model.exceptions.SuccessAPIResponse;
import com.onlineShoping.demo.service.CustomerService;

@RestController
@RequestMapping(path = {"/customer/{customerId}/cart"})
public class CartController {

	public CartController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	CustomerService customerService;

	@GetMapping
	public ShopingCart getCart(@PathVariable String customerId) {
		return customerService.getShopingCart(customerId);
	}

	@PostMapping
	public BaseAPIResponse addProdctTocart(@PathVariable String customerId,
			@RequestBody LineItem lineItem) {
		customerService.addProductToCart(customerId, lineItem);
		BaseAPIResponse apiResponse = new SuccessAPIResponse(
				"product added successfully");
		return apiResponse;
	}

	@PutMapping
	public BaseAPIResponse updateProdctIncart(@PathVariable String customerId,
			@RequestBody LineItem lineItem) {
		customerService.updateProdctQuantityInCart(customerId, lineItem);
		BaseAPIResponse apiResponse = new SuccessAPIResponse(
				"product quantity updated successfully");
		return apiResponse;
	}

	@DeleteMapping
	public BaseAPIResponse removeProdctFromcart(@PathVariable String customerId,
			@RequestBody LineItem lineItem) {
		customerService.removeProductFromCart(customerId, lineItem);
		BaseAPIResponse apiResponse = new SuccessAPIResponse(
				"product removed successfully");
		return apiResponse;
	}

	@ExceptionHandler(value = {CartUnderFlowException.class})
	public BaseAPIResponse handleCartUnderFlowException(
			CartUnderFlowException ex) {
		BaseAPIResponse apiResponse = new ErrorAPIResponse(
				HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.name(),
				ex.getMessage());
		return apiResponse;
	}

}
