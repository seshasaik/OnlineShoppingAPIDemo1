package com.onlineShoping.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/testCntrl")
public class TestController {
	ArrayList<HashMap<String, String>> list;
	public TestController() {
		// TODO Auto-generated constructor stub
		list = new ArrayList<>();
		HashMap<String, String> hero1 = new HashMap<String, String>();
		hero1.put("id", "1");
		hero1.put("name", "hero1");
		list.add(hero1);
		
		HashMap<String, String> hero2 = new HashMap<String, String>();
		hero2.put("id", "2");
		hero2.put("name", "hero2");
		list.add(hero1);
		
		
		
		HashMap<String, String> hero3 = new HashMap<String, String>();
		hero3.put("id", "3");
		hero3.put("name", "hero3");
		list.add(hero1);
	}

	@GetMapping()
	public ArrayList<HashMap<String, String>> getHeros() {
		return list;
	}
	
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addHero(HashMap<String, String> hero) {
		list.add(hero);
		
	}

}
