package com.bank.service;

import java.util.List;
import java.util.Map;

import com.bank.bean.Account;
import com.bank.bean.Customer;

public interface AcctountService {
	
	String transferFunds(int from,int to,double amount);
	Account getBalanceOf(int accountNumber);
	Account addAccount(Account acct);
	Map<Integer, Account> getAllAccounts();
	List<Customer> getAllCustomers();
}
