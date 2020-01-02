package com.onlineShoping.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.Supplier;

@Repository
public interface SupplierRepository extends MongoRepository<Supplier, String> {

}
