package com.onlineShoping.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.onlineShoping.demo.entity.GoodsReceipt;

@Repository
public interface GRNRepository extends MongoRepository<GoodsReceipt, String> , GRNRepositoryCustom {

}
