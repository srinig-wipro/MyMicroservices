package com.wipro.bank.bean;

import javax.persistence.*;

@Entity
public class Account {
	
	@Id
	@GeneratedValue
	@Column(name="ACCOUNT_ID")
	private int accountId;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Customer customer;
	
	@Column(name="BALANCE")
	private double balance;

	public Account() {
		super();
	}

	public Account(int accountId, Customer customer, double balance) {
		super();
		this.accountId = accountId;
		this.customer = customer;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
