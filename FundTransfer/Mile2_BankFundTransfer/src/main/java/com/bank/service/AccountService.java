package com.bank.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.bank.bean.Account;
import com.bank.bean.Customer;

import com.bank.dao.AccountDaoDB;
import com.bank.dao.CustomerDaoDB;
import com.bank.util.DBUtil;

public class AccountService {
	
	public String transferFunds(int from,int to,double amount){
		
		String response="ID MISMATCH";
	
		Map<Integer,Account> accountDetails=new AccountDaoDB().findAllAccounts();
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
											new AccountDaoDB().updateAccount(toAcc.getAccountID(), toAcc.getBalance());
											double fromNewBalane=fromAcc.getBalance()-amount;
											fromAcc.setBalance(fromNewBalane);
											new AccountDaoDB().updateAccount(fromAcc.getAccountID(), fromAcc.getBalance());
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
	
	public Account getBalanceOf(int accountNumber){
		return new AccountDaoDB().findAccountByID(accountNumber);
	}
	
	public Account addAccount(Account acct) {
		
		if(acct!=null) {
			acct.getCustomer().setCustomerID((int) new DBUtil().getId("customer_seq"));
			acct.setAccountID((int) new DBUtil().getId("account_seq"));
			new CustomerDaoDB().saveCustomer(acct.getCustomer());
			new AccountDaoDB().saveAccount(acct);		
		}
		return acct;
	}
	
	public Map<Integer, Account> getAllAccounts(){
		return new AccountDaoDB().findAllAccounts();
	}
	
	public List<Customer> getAllCustomers(){		
		return new CustomerDaoDB().findAllCustomers();
	}
}
