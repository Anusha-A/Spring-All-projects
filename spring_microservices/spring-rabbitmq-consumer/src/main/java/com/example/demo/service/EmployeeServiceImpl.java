package com.example.demo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.EmployeeRepository;
import com.example.demo.entity.Employee;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository; 
	@Override
	@Transactional
	public void save(Employee employee) {
		employeeRepository.save(employee);
		
		
	}

}
