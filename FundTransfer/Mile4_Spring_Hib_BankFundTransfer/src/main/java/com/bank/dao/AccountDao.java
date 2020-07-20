package com.bank.dao;

import java.util.List;
import java.util.Map;

import com.bank.bean.Account;
import com.bank.bean.Customer;

public interface AccountDao {

	Account saveAccount(Account acct);
	Map<Integer, Account> findAllAccounts();
	Account findAccountByID(int accountId);
	boolean updateAccount(int accountId, double balance);
}
