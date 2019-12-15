package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name="user")
@Data
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	   private String name;

	   private String practiceArea;

	   private String designation;

	   private String companyInfo;

	

}

