package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;

@Data
@Entity
@Table(name = "task")
public class Task 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private int task_id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="emp_id")
	private Employee empdetails;
	
	@Column(name = "progress")
	private int progress;
	
	@Column(name = "deadline")
	private Date deadline;
	
//	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
//	@JoinColumn(name = "phase_id")
//	private Phase phase;
}