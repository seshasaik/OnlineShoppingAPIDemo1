package com.onlineShoping.demo.repository;



import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.PurchaseOrder;

@Repository
public interface PurchaseOrderRepository
		extends
			MongoRepository<PurchaseOrder, String>, PurchaseOrderRepositoryCustom {

}
