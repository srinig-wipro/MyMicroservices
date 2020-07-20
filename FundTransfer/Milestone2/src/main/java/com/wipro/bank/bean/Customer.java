package com.wipro.bank.bean;

public class Customer {
	private int customerID;
	private String name;

	// No args constructor
	public Customer() {
	}

	// Overloaded constructor to initialize all member variables
	public Customer(int customerID, String name) {
		super();
		this.customerID = customerID;
		this.name = name;
	}

	// This method is overridden to return all instance variable values
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", name=" + name + "]";
	}
	

}// Customer
