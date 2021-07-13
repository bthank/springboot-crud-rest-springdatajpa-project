package com.binu.springboot.employeecrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.binu.springboot.employeecrud.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

	private EntityManager entityManager;
	
	// inject entityManager via constructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {

		// create a query
		Query theQuery = entityManager.createQuery("from Employee");
		
		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		// return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		 
//		Query theQuery = entityManager.createQuery("from Employee where id=:theId");
//		theQuery.setParameter("theId",theId);
//		 
//		Employee employee = (Employee)theQuery.getSingleResult();
//		
//		if (employee == null) {
//			throw new RuntimeException("Could not find employee with id: " + theId);
//		}
		
		Employee employee = entityManager.find(Employee.class, theId);
 		if (employee == null) {
 			throw new RuntimeException("Could not find employee with id: " + theId);
 		}
		
		// return the results
		return employee;
	}

	@Override
	public void save(Employee theEmployee) {
		 
		// merge will do a save if id=0, else will do an update
		Employee savedEmployee = entityManager.merge(theEmployee);
		
		//theEmployee.setId(savedEmployee.getId());
	}

	@Override
	public void update(Employee theEmployee) {
		 
		// merge will do a save if id=0, else will do an update
		entityManager.merge(theEmployee);
		
	}

	@Override
	public void deleteById(int theId) {
		 
//		Employee employeeToDelete = entityManager.find(Employee.class, theId);
//		if (employeeToDelete == null) {
//			throw new RuntimeException("Could not find employee id: " + theId);
//		}
//		entityManager.remove(employeeToDelete);
		
		Query theQuery = entityManager.createQuery("delete from Employee where id=:theId");
		theQuery.setParameter("theId", theId);
		
		theQuery.executeUpdate();
		
		
	}

}
