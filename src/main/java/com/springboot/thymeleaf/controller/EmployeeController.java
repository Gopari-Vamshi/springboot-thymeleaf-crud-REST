package com.springboot.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.thymeleaf.entity.Employee;
import com.springboot.thymeleaf.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("list")
	public String listEmployee(Model theModel) {
		
		List<Employee> theEmployees = employeeService.findAll();
		
		theModel.addAttribute("employees", theEmployees);
		return "employees/list-employees";
	}
	
	@GetMapping("/addForm")
	public String addEmployee(Model theModel) {

		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employees/employee-form";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
		
		employeeService.saveEmployee(theEmployee);
		
		return "redirect:/employees/list";
	}
	
	
	@GetMapping("/updateForm")
	public String showFormforUpdate(@RequestParam("employeeId") int theId, Model theModel) {
		
		//get employee from the service
		Employee theEmployee = employeeService.findEmployee(theId);
		
		//set employee as a model attribute to pre populate the form
		theModel.addAttribute("employee", theEmployee);
		
		//send over to our form
		return "employees/employee-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		//delete the eemployee
		employeeService.deleteEmployee(theId);
		
		return "redirect:/employees/list";
	}
}










