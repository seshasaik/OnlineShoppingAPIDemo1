package com.onlineShoping.demo.service;

import java.util.List;

import com.onlineShoping.demo.entity.Order;
import com.onlineShoping.demo.entity.ShopingCart;
import com.onlineShoping.demo.util.OrderStatus;

public interface OrderService {

	Order getOrder(String orderId);

	List<Order> getOrders(String accountId);

	void makeOrder(ShopingCart cart);

	void updateOrderStatus(String orderId, OrderStatus status);

	void deleteOrder(String orderId);

}
