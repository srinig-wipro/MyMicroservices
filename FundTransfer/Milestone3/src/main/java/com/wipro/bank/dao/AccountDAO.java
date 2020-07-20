package com.wipro.bank.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.wipro.bank.bean.Account;
import com.wipro.bank.bean.Customer;
import com.wipro.bank.util.DBConnection;

@Service
public class AccountDAO {
	
	public int createAccount(Account account) {
		int accountId =0;
		try {
			Session session = DBConnection.getDBSession();
			accountId = (int) session.save(account);
			DBConnection.closeDBSession(session);
		} catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return accountId;
	}
	
	public Account getAccountDetails(int accountId) {
		Account account = null;
		try {
			Session session = DBConnection.getDBSession();
		//	account =  session.find(Account.class, accountId);
			DBConnection.closeDBSession(session);
		} catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return account;
	}
	
	public List<Account> getAllAccountDetails() {
		List<Account> accounts = new ArrayList<>();
		try {
			Session session = DBConnection.getDBSession();
			accounts = session.createQuery("FROM Account").list();
			DBConnection.closeDBSession(session);
		} catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return accounts;
	}
	
	public List<Customer> getAllCustomerDetails() {
		List<Customer> customers = new ArrayList<>();
		try {
			Session session = DBConnection.getDBSession();
			customers =  session.createQuery("FROM Customer").list();
			DBConnection.closeDBSession(session);
		} catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return customers;
	}
	
	public void updateAccountDetails(Account account) {
		try {
			Session session = DBConnection.getDBSession();
			session.update(account);
			DBConnection.closeDBSession(session);
		} catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

}
