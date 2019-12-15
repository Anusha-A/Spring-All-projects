package com.example.demo.entity;



import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class Employee {

	private String empName;
	@Id
	private String empId;

	

	

}
