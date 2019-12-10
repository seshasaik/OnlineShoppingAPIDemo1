package com.onlineShoping.demo.service;

import java.util.List;

import com.onlineShoping.demo.entity.LineItem;
import com.onlineShoping.demo.entity.ShopingCart;

public interface ShopingCartService {

	ShopingCart findById(String cartId);

	void addLineItemsToCart(String cartId, List<LineItem> lineItems);

	void removeLineItemFromCart(String cartId, List<LineItem> lineItem);

}
