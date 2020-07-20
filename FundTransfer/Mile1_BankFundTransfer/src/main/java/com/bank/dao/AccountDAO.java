package com.bank.dao;

import java.util.ArrayList;
import java.util.List;

import com.bank.bean.Account;
import com.bank.bean.Customer;

public class AccountDAO {
	
	public static List<Account> accounts;
	public static List<Customer> customers;
	
	public static void defineDB(List<Account> accs) {
		accounts = accs;
		customers=new ArrayList<Customer>();
		for (Account a : accounts) {
			customers.add(a.getCustomer());
		}
	}

	
	public String saveAccount(Account account) {
		accounts.add(account);
		return "SUCCESS";
	}
	public List<Account> findAllAccounts(){
		return accounts;
	}
	public String saveCustomer (Customer customer) {
		customers.add(customer);
		return "SUCCESS";
	}
	
	public List<Customer> findAllCustomers(){
		return customers;
	}

}
