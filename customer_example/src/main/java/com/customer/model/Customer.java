package com.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Immutable;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="customer")
@Immutable
public class Customer {
	@Id
	@Column(name="customer_id")
	private int id;
	
	@NotNull
	@Column(name="customer_name")
	private String name=null;
	
	@Min(value=1007)
	@Max(value=2999)
	@Column(name="customer_no")
	private int cust_id=-1;
	
	@Column(name="customer_type")
	private String type=null;
	public Customer(String name, int cust_id, String type) {
		super();
		this.name=name;
		this.cust_id=cust_id;
		this.type=type;
	}
	
}
