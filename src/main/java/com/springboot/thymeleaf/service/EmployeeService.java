package com.springboot.thymeleaf.service;

import java.util.List;

import com.springboot.thymeleaf.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findEmployee(int theId);

	public void saveEmployee(Employee theEmployee);

	public void deleteEmployee(int theId);
}
