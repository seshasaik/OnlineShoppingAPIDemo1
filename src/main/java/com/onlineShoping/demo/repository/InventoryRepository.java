package com.onlineShoping.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.Inventory;

@Repository
public interface InventoryRepository
		extends
			MongoRepository<Inventory, String> {

}
