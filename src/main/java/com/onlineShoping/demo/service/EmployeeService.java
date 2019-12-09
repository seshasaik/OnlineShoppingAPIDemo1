package com.onlineShoping.demo.service;

import java.util.List;

import com.onlineShoping.demo.entity.Employee;

public interface EmployeeService {

	Employee findById(String id);

	List<Employee> findAll();

	Employee save(Employee employee);

	List<Employee> saveAll(List<Employee> employees);

	void update(Employee employee);

	void updateAll(List<Employee> employees);

	void deleteEmployee(String id);
}
