package com.binu.springboot.employeecrud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binu.springboot.employeecrud.entity.Employee;
import com.binu.springboot.employeecrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	
	
	private EmployeeService employeeService;
	
	// inject employee service using constructor injection
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		this.employeeService = theEmployeeService;
	}
	
	// expose "/employees" endpoint and return list of all employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		
		return employeeService.findAll();
	}
	
	// expose "/employees/{employeeId}" to find a single employee
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		
		if (theEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		return theEmployee;
	}
	
	// expose "/employees" to add an employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		// in case the user provided an id, change the id to 0 to force a save of a new record by Hibernate
		theEmployee.setId(0);
		
		employeeService.save(theEmployee);
		
		return theEmployee;
	}
	
	
	// expose "/employees" to update an employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		employeeService.update(theEmployee);
		
		return theEmployee;
	}
	
	
	// expose "/employees/{employeeId}" to delete an employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		Employee tempEmployee = employeeService.findById(employeeId);
		if (tempEmployee !=  null) {
			employeeService.deleteById(employeeId);
		} else {
			throw new RuntimeException("Could not find employee to delete for id: " + employeeId);
		}
		
		return "Deleted employee id " + employeeId;
		
	}
	
	
}
