package com.binu.springboot.employeecrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.binu.springboot.employeecrud.dao.EmployeeRepository;
import com.binu.springboot.employeecrud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	 
	EmployeeRepository employeeRepository;
	
	@Autowired         // note that the bean id in the @Qualifier must start with a lower case letter
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	//no need for using @Transactional since JPA Repository provides the same functionality automatically
	public List<Employee> findAll() {
		 
		return employeeRepository.findAll();
	}

	@Override
	//no need for using @Transactional since JPA Repository provides the same functionality automatically
	public Employee findById(int theId) {
		 
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException("Did not find employee with id: " + theId);
		}
		return theEmployee;
	}

	@Override
	//no need for using @Transactional since JPA Repository provides the same functionality automatically
	public void save(Employee theEmployee) {
		 
		employeeRepository.save(theEmployee);
	}

	@Override
	//no need for using @Transactional since JPA Repository provides the same functionality automatically
	public void update(Employee theEmployee) {
		 
		employeeRepository.save(theEmployee);
	}

	@Override
	//no need for using @Transactional since JPA Repository provides the same functionality automatically
	public void deleteById(int theId) {
		 
		employeeRepository.deleteById(theId);
	}

}
