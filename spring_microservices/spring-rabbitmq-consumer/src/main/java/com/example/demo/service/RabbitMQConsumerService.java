package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class RabbitMQConsumerService {
	
	@Autowired
	private EmployeeService employeeService;
	private static final String QUEUE = "foo.queue";

	@RabbitListener(queues = QUEUE)
	public void receiveMessage(Employee employee) {
		employeeService.save(employee);
		System.out.println("Received Message from foo-queue Queue >>" + employee);
	}


}
