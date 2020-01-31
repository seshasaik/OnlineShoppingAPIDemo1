package com.onlineShoping.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.onlineShoping.demo.entity.GoodsReceipt;

public class GRNRepositoryCustomImpl implements GRNRepositoryCustom {

	private MongoTemplate mongoTemplate;

	@Autowired
	public GRNRepositoryCustomImpl(MongoTemplate mongoTemplate) {
		// TODO Auto-generated constructor stub
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<GoodsReceipt> findAllGRNExculdingItems() {
		// TODO Auto-generated method stub

		Order order = new Order(Direction.DESC, "createdOn");
		Sort sort = Sort.by(order);

		Query query = new Query();

		query.fields().exclude("goodsReceiptItems").exclude("purchaseOrder");
		query.with(sort);

		return this.mongoTemplate.find(query, GoodsReceipt.class);
	}

}
