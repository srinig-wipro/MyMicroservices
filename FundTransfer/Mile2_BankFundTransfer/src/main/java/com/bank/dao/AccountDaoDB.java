package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bank.bean.Account;
import com.bank.bean.Customer;
import com.bank.util.DBUtil;

public class AccountDaoDB {
//	public static List<Account> accounts = new ArrayList<Account>();
//	public static List<Customer> customers = new ArrayList<Customer>();

	public static Connection con;

	public AccountDaoDB() {
		con = DBUtil.getH2Connection();
	}

	public Account saveAccount(Account acct) {
		int acctId = -1;
		if (acct != null) {

			try {
				String insertSQL = "insert into BFT_Account(accountid,customerid, balance) values (?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(insertSQL);
				pstmt.setLong(1, acct.getAccountID());
				pstmt.setLong(2, acct.getCustomer().getCustomerID());
				pstmt.setDouble(3, acct.getBalance());

				if (pstmt.executeUpdate() == 0) {
					System.out.println("Unable to save Account for customer :" + acct.getCustomer().getName());
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return acct;
	}

	public Map<Integer, Account> findAllAccounts() {
		Map<Integer, Account> accountMap = new HashMap<Integer, Account>();
		List<Account> accounts = new ArrayList<Account>();

		try {
			Statement stmt = con.createStatement();
			String Sql = "select * from BFT_Account a, BFT_Customer c where a.customerid = c.customerid";
			ResultSet rs = stmt.executeQuery(Sql);

			while (rs.next()) {
				Customer cust = new Customer();
				cust.setCustomerID((int) rs.getLong("customerid"));
				cust.setName(rs.getString("name"));
				Account acc = new Account();
				acc.setAccountID((int) rs.getLong("Accountid"));
				acc.setBalance(rs.getFloat("Balance"));
				acc.setCustomer(cust);
				accounts.add(acc);
				accountMap.put( acc.getAccountID(), acc);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (accountMap.size() == 0) {
			accountMap = null;
		}

		return accountMap;
	}
	
	public Account findAccountByID(int accountId) {
		Account acct=null;
		try {
			Statement stmt = con.createStatement();				
			String Sql = "select * from BFT_Account where accountid ="+accountId;	
			ResultSet rs = stmt.executeQuery(Sql);

			while (rs.next()) {

				acct=new Account();
				acct.setAccountID( rs.getInt("accountid"));	
				acct.setBalance(rs.getDouble("balance"));
				Customer cust=new CustomerDaoDB().findCustomerByID(rs.getInt("customerid"));
				acct.setCustomer(cust);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return acct;
	}

	public boolean updateAccount(int accountId, double balance) {
		boolean isSuccess = false;
		try {
			String insertSQL = "update BFT_Account set Balance = ? where Accountid = ?";
			PreparedStatement pstmt = con.prepareStatement(insertSQL);
			pstmt.setDouble(1, balance);
			pstmt.setLong(2, accountId);
			if (pstmt.executeUpdate() > 0) {
				isSuccess = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

}
