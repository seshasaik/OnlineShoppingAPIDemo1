package com.onlineShoping.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.onlineShoping.demo.entity.PurchaseOrder;
import com.onlineShoping.demo.util.PurchaseOrderStatus;

public class PurchaseOrderRepositoryCustomImpl
		implements
			PurchaseOrderRepositoryCustom {

	private MongoTemplate mongoTemplate;

	@Autowired
	public PurchaseOrderRepositoryCustomImpl(MongoTemplate mongoTemplate) {
		// TODO Auto-generated constructor stub
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<PurchaseOrder> findAllExcludeItems() {
		// TODO Auto-generated method stub

		Query query = new Query();
		query.fields().exclude("items");

		query.with(Sort.by(Direction.DESC, "cratedDate"));

		return this.mongoTemplate.find(query, PurchaseOrder.class);

	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public List<PurchaseOrder> findAllPendingOrdersExcludeItems() {
		// TODO Auto-generated method stub
		Query query = new Query();
		query.fields().exclude("items");

		query.with(Sort.by(Direction.DESC, "cratedDate"));

		Criteria criteria = Criteria.where("status");
		criteria.is(PurchaseOrderStatus.PENDING);
		
		query.addCriteria(criteria);

		return this.mongoTemplate.find(query, PurchaseOrder.class);

	}

}
