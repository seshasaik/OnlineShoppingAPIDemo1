package com.onlineShoping.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.Roles;
import com.onlineShoping.demo.util.UserRole;

@Repository
public interface RoleRepository extends MongoRepository<Roles, String> {
	Roles findByName(UserRole name);

}
