package com.binu.springboot.employeecrud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.binu.springboot.employeecrud.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// entity manager
	private EntityManager entityManager;
	
	// set up constructor injection of entity manager that is automatically created by Spring Boot
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
		
	}
	
	
	@Override
	public List<Employee> findAll() {
		
		// get current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query using native Hibernate API
		Query<Employee> theQuery = currentSession.createQuery("from Employee",Employee.class);
		
		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		// return the results
		return employees;
	}


	@Override
	public Employee findById(int theId) {
		
		// get current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the employee
		Employee theEmployee = currentSession.get(Employee.class,theId);
		
		return theEmployee;
	}


	@Override
	public void save(Employee theEmployee) {
		 	
		// get current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// save the employee (with saveOrUpdate, if id=0 it will do a save, else it will do an update)
		currentSession.saveOrUpdate(theEmployee);
		
		
	}


	@Override
	public void update(Employee theEmployee) {
	 	
		// get current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
	
		// update the employee (with saveOrUpdate, if id=0 it will do a save, else it will do an update)
		currentSession.saveOrUpdate(theEmployee);
	
	}
	
	
	@Override
	public void deleteById(int theId) {
		 
		// get current Hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete the employee with primary key id
		Query theQuery = currentSession.createQuery("delete from Employee where id=:theEmployeeId");
		theQuery.setParameter("theEmployeeId", theId);
		
		theQuery.executeUpdate();
		
	}



}
