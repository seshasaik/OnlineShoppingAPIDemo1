package com.onlineShoping.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.onlineShoping.demo.util.UserRole;

/**
 * @author kseshasai
 *
 */
@Document(collection = "roles")
public class Roles {

	@Id
//	@Field(name = "accountId")
	private String id;
	private UserRole name;
	private String description;
	
	public Roles() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserRole getName() {
		return name;
	}

	public void setName(UserRole name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
