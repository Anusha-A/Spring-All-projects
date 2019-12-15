package com.mycompany.inheritance;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="account_type")
@DiscriminatorValue("Normal Account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String account_number;
	private int balance;
	private String branch;
	
	public Account() {
	
		
	}
	public Account(String username, String account_number, int balance, String branch)
	{
		this.username = username;
		this.account_number =account_number;
		this.balance = balance;
		this.branch = branch;
	}
}
