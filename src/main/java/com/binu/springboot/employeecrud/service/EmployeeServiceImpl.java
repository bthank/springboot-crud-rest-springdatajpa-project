package com.binu.springboot.employeecrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.binu.springboot.employeecrud.dao.EmployeeDAO;
import com.binu.springboot.employeecrud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	 
	EmployeeDAO employeeDAO;
	
	@Autowired         // note that the bean id in the @Qualifier must start with a lower case letter
	public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO theEmployeeDAO) {
		this.employeeDAO = theEmployeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		 
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int theId) {
		 
		return employeeDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Employee theEmployee) {
		 
		employeeDAO.save(theEmployee);
	}

	@Override
	@Transactional
	public void update(Employee theEmployee) {
		 
		employeeDAO.update(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		 
		employeeDAO.deleteById(theId);
	}

}
