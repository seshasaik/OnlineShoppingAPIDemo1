package com.onlineShoping.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
	Employee findBy_id(String _id);

}
