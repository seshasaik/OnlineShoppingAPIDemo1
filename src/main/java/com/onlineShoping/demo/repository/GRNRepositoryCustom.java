package com.onlineShoping.demo.repository;

import java.util.List;

import com.onlineShoping.demo.entity.GoodsReceipt;

public interface GRNRepositoryCustom {
	
	public List<GoodsReceipt> findAllGRNExculdingItems();
	
	

}
