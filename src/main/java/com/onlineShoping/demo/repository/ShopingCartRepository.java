package com.onlineShoping.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.ShopingCart;

@Repository
public interface ShopingCartRepository extends MongoRepository<ShopingCart, String> {

}
