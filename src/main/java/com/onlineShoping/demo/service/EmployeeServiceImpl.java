package com.onlineShoping.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.onlineShoping.demo.entity.Employee;
import com.onlineShoping.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee findById(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.findBy_id(id);
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "_id"));
	}

	@Override
	public Employee save(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		this.save(employee);
	}

	@Override
	public void deleteEmployee(String id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);

	}

	@Override
	public List<Employee> saveAll(List<Employee> employees) {
		// TODO Auto-generated method stub
		return employeeRepository.saveAll(employees);
	}

	@Override
	public void updateAll(List<Employee> employees) {
		// TODO Auto-generated method stub
		this.saveAll(employees);
	}

}
