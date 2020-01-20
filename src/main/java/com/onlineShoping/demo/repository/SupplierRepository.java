package com.onlineShoping.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.Supplier;

@Repository
public interface SupplierRepository extends MongoRepository<Supplier, String> {

	Optional<Supplier> findByRegNumberOrMobile(String regNumber, String mobile);

	@Query("{'$or':[{mobile: ?0}, {regNumber: ?1}], '$ne':{id:?2}}")
	Optional<Supplier> findByMobileNumberOrRegNumberAndIdNot(String mobile,
			String regNumber, String id);

}
