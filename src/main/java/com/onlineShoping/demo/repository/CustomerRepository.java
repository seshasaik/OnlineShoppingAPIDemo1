package com.onlineShoping.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
	Customer findByEmail(String email);

	Customer findByPhone(String phone);

}
