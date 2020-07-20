package com.bank.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.bean.Account;
import com.bank.bean.Customer;
import com.bank.dao.AccountDao;
import com.bank.dao.CustomerDao;

@Service
public class AccountServiceImpl implements AcctountService {
	
	private static final Logger LOG = Logger.getLogger(xAccountServiceRef.class.getName());
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	CustomerDao customerDao;

	@Override
	public String transferFunds(int from, int to, double amount) {
		String response="ID MISMATCH";
		
		Map<Integer,Account> accountDetails=accountDao.findAllAccounts();
		Collection<Account> accounts= accountDetails.values();
				
		if(accounts.size()>0) {
			
		
			if(amount>0){
				back: for(Account fromAcc:accounts){
					if(fromAcc!=null){
						if(from==fromAcc.getAccountID()){
							if(fromAcc.getBalance()>=amount){
								for(Account toAcc:accounts){
									if(toAcc!=null){
										if(to==toAcc.getAccountID()){
											double toNewBalance=amount+toAcc.getBalance();
											toAcc.setBalance(toNewBalance);
											accountDao.updateAccount(toAcc.getAccountID(), toAcc.getBalance());
											double fromNewBalane=fromAcc.getBalance()-amount;
											fromAcc.setBalance(fromNewBalane);
											accountDao.updateAccount(fromAcc.getAccountID(), fromAcc.getBalance());
											response="SUCCESS";
											break back;
										}
									}
								}
							}else{
								response="INSUFFICIENT FUNDS";
							}
						}
					}
				}
			}
		}
		
		
		
		
		return response;
	}

	@Override
	public Account getBalanceOf(int accountNumber) {
		Account acct=null;
		//acct=accountDao.findAccountByID(accountNumber);
		return acct;
	}

	@Override
	public Account addAccount(Account acct) {
		
		LOG.info("Creating New Account for user "+ acct.getCustomer().getName());
		if(acct!=null) {
			customerDao.saveCustomer(acct.getCustomer());
			accountDao.saveAccount(acct);		
		}
		return acct;
	}

	@Override
	public Map<Integer, Account> getAllAccounts() {
		Map<Integer, Account> accounts=null;
		accounts= accountDao.findAllAccounts();
		return accounts;
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customers=null;
		customers=customerDao.findAllCustomers();
		return customers;
	}

}
