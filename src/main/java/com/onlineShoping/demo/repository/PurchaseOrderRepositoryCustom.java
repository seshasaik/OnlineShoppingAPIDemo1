package com.onlineShoping.demo.repository;

import java.util.List;

import com.onlineShoping.demo.entity.PurchaseOrder;

public interface PurchaseOrderRepositoryCustom {

	List<PurchaseOrder> findAllExcludeItems();
	
	List<PurchaseOrder> findAllPendingOrdersExcludeItems();
}
