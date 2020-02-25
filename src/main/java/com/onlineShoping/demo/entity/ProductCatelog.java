package com.onlineShoping.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "proudctCatelog")
public class ProductCatelog {

	public ProductCatelog() {
		// TODO Auto-generated constructor stub
	}

	@Id
	private String id;

	private String[] children;

}
