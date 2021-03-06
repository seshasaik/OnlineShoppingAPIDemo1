package com.onlineShoping.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.GoodsOrder;

@Repository
public interface OrderRepository extends MongoRepository<GoodsOrder, String> {

}
