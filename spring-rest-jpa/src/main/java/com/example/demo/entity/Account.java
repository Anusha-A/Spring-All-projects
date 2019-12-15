package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_number")
	private Long accountNumber;
	
	@Column(name="account_type")
	private AccountType accountType;
	
	@Column(name="active_status")
	private boolean isActive;

}
