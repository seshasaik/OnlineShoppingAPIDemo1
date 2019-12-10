package com.onlineShoping.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {

}
