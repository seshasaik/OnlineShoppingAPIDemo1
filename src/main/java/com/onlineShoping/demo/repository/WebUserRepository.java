package com.onlineShoping.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.WebUser;

@Repository
public interface WebUserRepository extends MongoRepository<WebUser, String> {
	WebUser findByUserId(String loginId);

}
