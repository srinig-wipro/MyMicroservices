package com.wipro.bank.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue
	@Column(name="CUSTOMER_ID")
	private int cutomerId;
	
	@Column(name="NAME")
	private String name;

	public Customer() {
	}
	
	public Customer(int cutomerId, String name) {
		super();
		this.cutomerId = cutomerId;
		this.name = name;
	}

	public int getCutomerId() {
		return cutomerId;
	}

	public void setCutomerId(int cutomerId) {
		this.cutomerId = cutomerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
