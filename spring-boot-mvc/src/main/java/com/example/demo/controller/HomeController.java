package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Employee;
import com.example.demo.service.EmployeeService;



@Controller
public class HomeController {
	private EmployeeService employeeService;
	
	public HomeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	@RequestMapping("/showForm")
	public String showForm(Model model)
	{
		model.addAttribute("employee",new Employee());
		return "show-form";
	}
	

	@RequestMapping("/processform")
	public String processForm(@ModelAttribute("employee") Employee employee , Model model)
	{
		Employee theEmployee = employeeService.save(employee);
		model.addAttribute("employee", theEmployee);
		return "process-employee";
	}

}
