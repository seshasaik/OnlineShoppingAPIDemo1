package com.onlineShoping.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
	

	Optional<Customer> findByEmail(String email);
	
	Optional<Customer> findByEmailAndCustomerIdNot(String email, String customerId);

	Optional<Customer> findByPhone(String phone);

	List<Customer> findByPhoneOrEmail(String phone, String email, Pageable pageable);

}
