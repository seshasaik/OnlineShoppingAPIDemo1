package com.onlineShoping.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	@Query(value = "{'suppliers.id':?0}")
	List<Product> findSuppliersById(String id);
}
