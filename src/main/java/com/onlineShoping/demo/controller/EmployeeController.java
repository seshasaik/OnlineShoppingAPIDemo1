package com.onlineShoping.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineShoping.demo.entity.Employee;
import com.onlineShoping.demo.service.EmployeeService;

@RestController
@RequestMapping(path = "employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping
	public List<Employee> getEmployees() {
		return employeeService.findAll();
	}

	@GetMapping(path = "/{id}")
	public Employee findEmployeesById(@PathVariable(name = "id") String employeeId) {
		return employeeService.findById(employeeId);
	}

	@PostMapping
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@PutMapping
	public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
		employeeService.update(employee);
		return new ResponseEntity<String>("Updated", HttpStatus.OK);
	}

}
