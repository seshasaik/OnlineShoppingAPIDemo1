package com.onlineShoping.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.LineItem;

@Repository
public interface LineItemRepository extends MongoRepository<LineItem, String> {

}
