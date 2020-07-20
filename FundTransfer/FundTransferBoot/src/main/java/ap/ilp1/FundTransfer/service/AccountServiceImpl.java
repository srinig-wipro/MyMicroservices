/*
 *
 * Copyright 2014 Wipro Technologies All rights reserved.
 * 
 * Customer specific copyright notice     :
 *
 * File Name       : Transfer.java
 *
 * Description     :Project desc.
 *
 * Version         : 1.0.0.
 *
 * Created Date    :Mar 7, 2017
 * 
 */
package ap.ilp1.FundTransfer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ap.ilp1.FundTransfer.dao.AccountDAO;
import ap.ilp1.FundTransfer.dao.CustomerDAO;
import ap.ilp1.FundTransfer.entity.Account;
import ap.ilp1.FundTransfer.entity.Customer;


/**
 * @author - avinash.patel@wipro.com
 * Date : Mar 7, 2017
 */

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountDAO accdao;
	
	@Autowired 
	CustomerDAO customerdao;
	
	
	public String transferFunds(int from,int to,double amount){
		String response="ID MISMATCH";
		List<Account> accounts=accdao.findAll();
		
		if(amount>0){
			back: for(Account fromAcc:accounts){
				if(fromAcc!=null){
					if(from==fromAcc.getId()){
						if(fromAcc.getBalance()>=amount){
							for(Account toAcc:accounts){
								if(toAcc!=null){
									if(to==toAcc.getId()){
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
		List<Account> accounts=accdao.findAll();
		
		for(Account acc:accounts){
			if(acc!=null){
				if(accountNumber==acc.getId()){
					account=acc;
				}
			}
		}
		return account;
	}
	

	
	public List<Account> getAllAccounts(){
		return accdao.findAll();
	}
	
	public List<Customer> getAllCustomers(){
		List<Account> accs=accdao.findAll();
		List<Customer> cutomers=new ArrayList<Customer>();
		
		for(Account a: accs) {
			cutomers.add(a.getCustomer());
		}
		
		return cutomers;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		
		return customerdao.save(customer);
	}
	
	

}
