package com.bank.dao;

import java.util.List;

import com.bank.bean.Customer;

public interface CustomerDao {
	Customer saveCustomer(Customer cust);
	List<Customer> findAllCustomers();
	Customer findCustomerByID(int customerId);

}
