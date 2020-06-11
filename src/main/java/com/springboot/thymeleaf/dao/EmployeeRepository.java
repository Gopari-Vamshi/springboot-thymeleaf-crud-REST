package com.springboot.thymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.thymeleaf.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	//that's it no need to write any code.
	
	public List<Employee> findAllByOrderByLastNameAsc();
}
