package com.onlineShoping.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.Inventory;
import com.onlineShoping.demo.entity.Product;

@Repository
public interface InventoryRepository
		extends
			MongoRepository<Inventory, String> {

	Optional<Inventory> findByProduct(Product product);
}
