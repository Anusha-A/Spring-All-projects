package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Account {

	@Id
	@Column(name = "account_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long accountNumber;
	@UniqueElements
	@Column(name = "account_type")
	private AccountType accoutType;
	@Column(name = "active_status")
	private boolean isActive;
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "cust_id", nullable = false)
	    @OnDelete(action = OnDeleteAction.CASCADE)
	    @JsonIgnore
	    private Customer customer;
}

