package com.wipro.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.Account.util.DBUtil;
import com.wipro.bank.bean.Account;
import com.wipro.bank.bean.Customer;

public class AccountDao {
	private static final String INSERT_ACCOUNT_QUERY = "insert into account(accountid,customerid,balance) values(?,?,?)";
	private static final String INSERT_CUSTOMER_QUERY = "insert into customerprofile(id,name) values(?,?)";

	public boolean saveAccount(Account Account) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getDBConnection();
		Customer cust = Account.getCustomer();
		PreparedStatement ps = conn.prepareStatement(INSERT_ACCOUNT_QUERY);
		ps.setInt(1, Account.getAccountID());
		ps.setInt(2, cust.getCustomerID());
		ps.setDouble(3, Account.getBalance());
		ps.execute();
		PreparedStatement ps1 = conn.prepareStatement(INSERT_CUSTOMER_QUERY);
		ps1.setInt(1, cust.getCustomerID());
		ps1.setString(2, cust.getName());
		ps1.execute();
		return true;
	}// saveAccount

	public boolean transferAmount(int fromAccount, int toAccount, double amount)
			throws ClassNotFoundException, SQLException {
		boolean result = false;
		Connection conn = DBUtil.getDBConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select balance from account where accountid=" + fromAccount);
		rs.next();
		double amt = rs.getDouble(1);
		if (amount <= amt) {
			Statement st1 = conn.createStatement();
			st.addBatch("update account set balance=balance -" + amount + " where accountid=" + fromAccount);
			st.addBatch("update account set balance=balance +" + amount + " where accountid=" + toAccount);
			int res[] = st.executeBatch();
			for (int i : res) {
				if (i == 0)
					result = false;
				else
					result = true;
			}
			return result;
		} else
			return result;
	}// transferAmount

	public double getBalance(int acc) throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getDBConnection();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select balance from account where accountid=" + acc);
		rs.next();
		double amt = rs.getDouble(1);
		return amt;
	}

	// This method is expected to return all account details with their customer
	// profile
	public List<Account> findAllAccounts() throws ClassNotFoundException, SQLException {
		Connection conn = DBUtil.getDBConnection();
		List<Account> accList = new ArrayList<Account>();

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select accountid,customerid,balance from account");
		while (rs.next()) {
			Account acc = new Account();
			Customer cust = new Customer();
			acc.setAccountID(rs.getInt(1));
			cust.setCustomerID(rs.getInt(2));
			acc.setCustomer(cust);
			acc.setBalance(rs.getDouble(3));
			accList.add(acc);
		}
		return accList;
	}// findAllAccount

	// This method is expected to return all Customers profile
	public List<Customer> findAllCustomers() throws SQLException, ClassNotFoundException {
		Connection conn = DBUtil.getDBConnection();
		List<Customer> custList = new ArrayList();

		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select id,name from customerprofile");
		while (rs.next()) {
			Customer cust = new Customer();
			cust.setCustomerID(rs.getInt(1));
			cust.setName(rs.getString(2));
			custList.add(cust);
		}
		return custList;
	}// findAllcustomer

}// AccountDao
