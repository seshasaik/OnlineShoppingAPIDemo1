package com.onlineShoping.demo.service;

import java.util.List;

import com.onlineShoping.demo.entity.Payment;

public interface PaymentService {

	Payment getPayment(String paymentId);

	List<Payment> getPaymentsByOrderId(String orderId);

	List<Payment> getPaymentsByAccountId(String accountId);

	void makePaymentForOrder(String orderId, Payment payment);

	void makePaymentForAccount(String accountId, Payment payment);

}
