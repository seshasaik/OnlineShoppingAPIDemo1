package com.onlineShoping.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

}
