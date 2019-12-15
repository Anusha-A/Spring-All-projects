package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int emp_id;
	
	@Column(name = "first_name")
	private String first_name;
	
	@Column(name = "last_name")
	private String last_name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "availability")
	private boolean availability;
	
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name = "project_id")
	private Project project;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="task_id")
	private Task task;
	
	
	
	
}
