package com.binu.springboot.employeecrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.binu.springboot.employeecrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
