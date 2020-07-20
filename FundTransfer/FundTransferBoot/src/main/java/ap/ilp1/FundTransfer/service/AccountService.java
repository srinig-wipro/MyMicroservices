package ap.ilp1.FundTransfer.service;

import java.util.List;

import ap.ilp1.FundTransfer.entity.Account;
import ap.ilp1.FundTransfer.entity.Customer;

public interface AccountService {
	String transferFunds(int from,int to,double amount);
	Account getBalanceOf(int accountNumber);
	List<Account> getAllAccounts();
	List<Customer> getAllCustomers();
	Customer addCustomer(Customer customer);
}
