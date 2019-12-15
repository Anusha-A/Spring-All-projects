package com.mycompany.inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@DiscriminatorValue("Savings Account")
public class SavingAccount extends Account {
	private int min_balance;
	public SavingAccount() {
		super();
	}
	public SavingAccount(String username, String account_number, int balance, String branch, int min_balance) {
		super(username,account_number,balance,branch);
		this.min_balance = min_balance;
	}
}
