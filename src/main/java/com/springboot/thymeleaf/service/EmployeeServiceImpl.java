package com.springboot.thymeleaf.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.thymeleaf.dao.EmployeeRepository;
import com.springboot.thymeleaf.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	
	@Override
	public Employee findEmployee(int theId) {

		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		return theEmployee;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {

		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteEmployee(int theId) {

		employeeRepository.deleteById(theId);
	}

}
