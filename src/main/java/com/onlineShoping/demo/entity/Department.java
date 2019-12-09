package com.onlineShoping.demo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "testCollection")
public class Department {

	@Id
	private String id;
	private String name;
	private String address;
	@DBRef
	private List<Employee> employees;
}
