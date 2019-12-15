package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;

import com.example.demo.service.EmployeeService;
import com.example.demo.service.RabbitMQSender;


@RestController
@RequestMapping(value = "/java-rabbitmq/")
public class RabbitWenMqWebController {
	@Autowired
	RabbitMQSender rabbitMQSender;
		

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("empName") String empName,@RequestParam("empId") String empId) {
	
	Employee emp=new Employee();
	emp.setEmpId(empId);
	emp.setEmpName(empName);
	
		rabbitMQSender.send(emp);

		return "Message sent to the RabbitMQ  Successfully";
	}


}
