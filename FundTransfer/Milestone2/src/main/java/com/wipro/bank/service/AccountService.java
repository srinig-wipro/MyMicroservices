package com.wipro.bank.service;

import java.sql.SQLException;
import java.util.List;

import com.wipro.bank.bean.Account;
import com.wipro.bank.bean.Customer;
import com.wipro.bank.dao.AccountDao;

public class AccountService {
	private AccountDao dao = null;

	public AccountService() {
		dao = new AccountDao();
	}

	// This method is expected to receive Account object and creates account and
	// customer details by invoking appropriate DAO
	public String addAccount(Account acc) throws ClassNotFoundException, SQLException {

		if (dao.saveAccount(acc))
			return "Account with Account id :" + acc.getAccountID() + " Successfully inserted in database";
		else
			return "Internal problem";
	}// addAccount

	// This method is expected to return all Accounts including customer profile
	public List<Account> getAllAccounts() throws ClassNotFoundException, SQLException {
		return dao.findAllAccounts();
	}// getAllAccounts

	// This method is expected to return all Customers details
	public List<Customer> getAllCustomers() throws ClassNotFoundException, SQLException {
		return dao.findAllCustomers();
	}// getAllCustomers

	/*
	 * This method is expected to return transfer status like â€œID MISATCHâ€� or
	 * â€œINSUFFICIENT FUNDSâ€� or â€œSUCCESSâ€� only. It iterates
	 * throughâ€œaccountsâ€� to find existence idâ€™s for both payer and
	 * beneficiary,if both found and if payer has sufficient funds then updates the
	 * balance for both accounts suitably.
	 */

	public String transferFunds(int from, int to, double amount) throws ClassNotFoundException, SQLException {
		if (dao.transferAmount(from, to, amount))
			return "Amount of Rs " + amount + " is transfered from Acc no :" + from + " to Acc no :" + to;
		else
			return "some problem occurs , please check account no and amount";
	}// transferFunds

	/*
	 * This method is expected to return account details by mapping account number.
	 * It iterates throughâ€œaccountsâ€� to find existence of received account
	 * number,if account number found it will return account object (details).
	 * Otherwise â€œnullâ€� to be returned.
	 */
	public double getBalanceOf(int accountNumber) throws ClassNotFoundException, SQLException {
		return dao.getBalance(accountNumber);
	}

}// AccountService
