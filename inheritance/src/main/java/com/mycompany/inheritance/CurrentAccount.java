package com.mycompany.inheritance;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@DiscriminatorValue("Current Account")
public class CurrentAccount extends Account {
	private Date create_date;
	public CurrentAccount() {
		super();
	}
	public CurrentAccount(String username, String account_number, int balance, String branch, Date create_date)
	{
		super(username,account_number,balance,branch);
		this.create_date = create_date;
	}

}
