package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.demo.service.EmployeeService;

@SpringBootApplication
public class SpringBootMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcApplication.class, args);
	}
	
	@Component
	class EmployeeCommandLineRunner implements CommandLineRunner
	{
		@Autowired
		private EmployeeService employeeService;
		
		@Override
		public void run(String... args) throws Exception{
			Employee employee = null;
			employee = new Employee();
			employee.setFirstName("Jonny");
			employee.setLastName("Doe");
			employee.setSalary(20000);
			employeeService.save(employee);
			
			employee.setFirstName("Sunadara");
			employee.setLastName("Doe");
			employee.setSalary(20000);
			employeeService.save(employee);
			
			employee.setFirstName("Jaana");
			employee.setLastName("Doe");
			employee.setSalary(20000);
			employeeService.save(employee);
		}
	}

}
