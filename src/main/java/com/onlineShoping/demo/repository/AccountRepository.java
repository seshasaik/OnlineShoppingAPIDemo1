package com.onlineShoping.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.Account;
import com.onlineShoping.demo.entity.Customer;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

	
	
	
}
