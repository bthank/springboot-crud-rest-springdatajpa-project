package com.binu.springboot.employeecrud.service;

import java.util.List;

import com.binu.springboot.employeecrud.entity.Employee;

public interface EmployeeService {

	
	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void update(Employee theEmployee);
	
	public void deleteById(int theId);
	
	
	
}
