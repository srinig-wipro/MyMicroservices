package com.bank.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.bean.Account;
import com.bank.bean.Customer;


@Service
public class xAccountServiceRef {
	
//	@Autowired
//	AccountDAO accountDao;
	
	private static final Logger LOG = Logger.getLogger(xAccountServiceRef.class.getName());
	
//	public int createAccount(String name, double amount) throws Exception{
//		LOG.info("Creating New Account for user "+ name);
//		Customer customer = new Customer();
//		customer.setName(name);
//		
//		Account account = new Account();
//		account.setBalance(amount);
//		account.setCustomer(customer);
//		
//		int accountId = accountDao.createAccount(account);
//		LOG.info("Created New Account for user "+ name + " sucessfully");
//
//		return accountId;
//	}
	
//	public Account getAccountdetails(int accountId) throws Exception{
//		LOG.info("Fetching account details for account ID "+ accountId);
//		Account account = accountDao.getAccountDetails(accountId);
//		return account;
//	}
	
//	public List<Account> getAllAccountdetails() throws Exception{
//		LOG.info("Fetching  all account details");
//		List<Account> accounts = accountDao.getAllAccountDetails();
//		return accounts;
//	}
	
//	public List<Customer> getAllCustomerDetails() throws Exception{
//		LOG.info("Fetching  all customer details");
//		List<Customer> customers = accountDao.getAllCustomerDetails();
//		return customers;
//	}
	
//	public String transferFunds(int fromAccountId, int toAccountId, int transferAmount) throws Exception{
//		LOG.info("Initiating fund transfer from "+ fromAccountId +" to "+  toAccountId);
//
//		String returnMessage = "";
//		Account fromAccount = getAccountdetails(fromAccountId);
//		Account toAccount = getAccountdetails(toAccountId);
//		
//		if(fromAccount == null) {
//			returnMessage = "Invalid sender account. Please verify the sender account number!";
//		} else if(toAccount == null) {
//			returnMessage = "Invalid receiver account. Please verify the receiver account number!";
//		} else if(fromAccount.getBalance() < transferAmount) {
//			returnMessage = "Insufficient Funds in sender account!";
//		} else {
//			int senderBalAmt = (int) (fromAccount.getBalance() - transferAmount);
//			int receiverBalAmt = (int) (toAccount.getBalance() + transferAmount);
//			fromAccount.setBalance(senderBalAmt);
//			toAccount.setBalance(receiverBalAmt);
//			accountDao.updateAccountDetails(fromAccount);
//			accountDao.updateAccountDetails(toAccount);
//			returnMessage = "Transferred fund successfully !";
//		}
//		LOG.info("Completed fund transfer from "+ fromAccountId +" to "+  toAccountId+ "with return message "+ returnMessage);
//
//		return returnMessage;
//	}
	

}
