package com.springboot.thymeleaf.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {

	// create a mapping for "/hello"
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello(Model theModel) {
		
		theModel.addAttribute("theDate", new Date());
		
		return "helloworld";
	}
}
