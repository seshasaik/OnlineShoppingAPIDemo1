package com.onlineShoping.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.GoodsReceipt;
import com.onlineShoping.demo.entity.PurchaseOrder;

@Repository
public interface GRNRepository extends MongoRepository<GoodsReceipt, String> , GRNRepositoryCustom {

	List<GoodsReceipt> findAllByPurchaseOrder(PurchaseOrder purchaseOrder);
}
