package com.onlineShoping.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.Inventory;
import com.onlineShoping.demo.entity.Product;
import com.onlineShoping.demo.util.ProductStatus;

@Repository
public interface InventoryRepository
		extends
			MongoRepository<Inventory, String> {

	Optional<Inventory> findByProduct(Product product);

	List<Inventory> findByStatus(ProductStatus status);
}
