package com.bank.service;

import java.util.ArrayList;
import java.util.List;

import com.bank.bean.Account;
import com.bank.bean.Customer;
import com.bank.dao.AccountDAO;

public class AccountService {
	public String transferFunds(int from,int to,double amount){
		String response="ID MISMATCH";
		List<Account> accounts=new AccountDAO().findAllAccounts();
		
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
										double fromNewBalane=fromAcc.getBalance()-amount;
										fromAcc.setBalance(fromNewBalane);
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
		
		return response;
	}
	
	public Account getBalanceOf(int accountNumber){
		Account account=null;
		List<Account> accounts=new AccountDAO().findAllAccounts();
		
		for(Account acc:accounts){
			if(acc!=null){
				if(accountNumber==acc.getAccountID()){
					account=acc;
				}
			}
		}
		return account;
	}
	
	public String addAccount(Account acc) {
		return new AccountDAO().saveAccount(acc);
	}
	
	public List<Account> getAllAccounts(){
		return new AccountDAO().findAllAccounts();
	}
	
	public List<Customer> getAllCustomers(){
		List<Account> accs=new AccountDAO().findAllAccounts();
		List<Customer> cutomers=new ArrayList<Customer>();
		
		for(Account a: accs) {
			cutomers.add(a.getCustomer());
		}
		
		return cutomers;
	}
}
