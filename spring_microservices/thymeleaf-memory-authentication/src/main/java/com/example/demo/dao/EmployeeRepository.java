package com.example.demo.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
public List<Employee> findAllByOrderByLastNameAsc();
	
	// search by name
	public List<Employee> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lName);

}
