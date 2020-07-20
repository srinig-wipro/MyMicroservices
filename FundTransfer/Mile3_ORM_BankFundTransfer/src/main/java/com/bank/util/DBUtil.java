package com.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.bean.Account;
import com.bank.bean.Customer;
import com.bank.dao.AccountDaoDB;
import com.bank.dao.CustomerDaoDB;

public class DBUtil {
	public static Connection con = null;

	public static Connection getMySqlConnection() {
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		String connectionUrl = "jdbc:mysql://localhost:3306/devops";
		String username = "devops";
		String password = "devops";
		Connection con = null;

		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(connectionUrl, username, password);
			// System.out.println(con +"Connection Established");
		}
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;

	}

	public static Connection getH2Connection() {
		String JDBC_DRIVER = "org.h2.Driver";
		String connectionUrl = "jdbc:h2:~/test";
		String username = "sa";
		String password = "";
		Connection con = null;

		try {
			Class.forName(JDBC_DRIVER);
			con = DriverManager.getConnection(connectionUrl, username, password);
			//System.out.println(con + "Connection Established");
		}
		// Handle any errors that may have occurred.
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void createTablesAndSequences(Connection con) {
		// create sequence for Account Table & Customer Table

		String s1 = "create table BFT_Account" + "(accountid number ,customerid number,balance number)";
		String s2 = "create table BFT_Customer" + "(customerid number ,name  varchar(10))";

		String acc = "CREATE SEQUENCE account_seq START WITH 11 INCREMENT BY 1";
		String cust = "CREATE SEQUENCE customer_seq START WITH 11 INCREMENT BY 1";
		Statement stmt;

		try {
			stmt = con.createStatement();
			stmt.executeUpdate("DROP TABLE IF EXISTS BFT_Account ");
			stmt.executeUpdate("DROP TABLE IF EXISTS BFT_Customer ");
			stmt.executeUpdate("DROP SEQUENCE account_seq IF EXISTS");
			stmt.executeUpdate("DROP SEQUENCE customer_seq IF EXISTS");
			stmt.executeUpdate(s1);
			stmt.executeUpdate(s2);
			stmt.executeUpdate(acc);
			stmt.executeUpdate(cust);
			//System.out.println("### Tables are created ####");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public long getId(String seq) {
		long value = -1;
		if (seq != null) {
			Connection con = new DBUtil().getH2Connection();
			if (con != null) {
				String myQ = "SELECT " + seq + ".nextval;";
				// + ".NEXTVAL FROM DUAL
			//	System.out.println(myQ);
				try {
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(myQ);
					if (rs.next()) {
						value = rs.getLong(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}

	public static void defineDB(List<Account> accounts) {		
		for (Account a : accounts) {
			//int accttId = (int) new DBUtil().getId("account_seq");
			//int custId = (int) new DBUtil().getId("customer_seq");
			//a.setAccountID(accttId);
			//a.getCustomer().setCustomerID(custId);			
			new CustomerDaoDB().saveCustomer(a.getCustomer());
			new AccountDaoDB().saveAccount(a);
		}
	}

}
