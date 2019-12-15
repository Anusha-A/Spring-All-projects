package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;



@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDAO employeeDAO;
	
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}


	@Override
	@Transactional
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployee();
	}


	@Override
	@Transactional
	public void save(Employee employee) {
		
		employeeDAO.save(employee);
	}


	@Override
	@Transactional
	public Employee update(Employee theEmployee) {
		return employeeDAO.update(theEmployee);
		//return null;
	}


	@Override
	@Transactional
	public Employee fingById(int theId) {
		// TODO Auto-generated method stub
		return employeeDAO.fingById(theId);
	}


	@Override
	@Transactional
	public List<Employee> fingByEmail(String email) {
		// TODO Auto-generated method stub
		return employeeDAO.fingByEmail(email);
	}


	@Override
	public void delete(int theId) {
		// TODO Auto-generated method stub
		employeeDAO.delete(theId);
		
	}

}

