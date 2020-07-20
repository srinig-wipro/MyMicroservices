package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.bean.Account;
import com.bank.bean.Customer;
import com.bank.util.DBUtil;

public class CustomerDaoDB {

	public static Connection con;

	public CustomerDaoDB() {
		con = DBUtil.getH2Connection();
	}

	public Customer saveCustomer(Customer cust) {
		int custId = -1;

		if (cust != null) {
					
				try {
					String insertSQL = "insert into BFT_Customer(customerid, name) values (?, ?)";
					PreparedStatement pstmt = con.prepareStatement(insertSQL);
					pstmt.setLong(1, cust.getCustomerID());
					pstmt.setString(2, cust.getName());

					if (pstmt.executeUpdate() == 0) {
						System.out.println("Unable to save Customer Record"+cust.getName());
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		return cust;
	}

	
	public List<Customer> findAllCustomers(){
		List<Customer> customers=new ArrayList<Customer>();
		
		try {
			Statement stmt = con.createStatement();
			String Sql = "select * from BFT_Customer";
			ResultSet rs = stmt.executeQuery(Sql);
			
			while (rs.next()) {
				Customer cust = new Customer();
				cust.setCustomerID((int) rs.getLong("customerid"));
				cust.setName(rs.getString("name"));				
				customers.add(cust);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customers;
	}
	
	public Customer findCustomerByID(int customerId) {
		Customer cust=null;
		try {
			Statement stmt = con.createStatement();				
			String Sql = "select * from BFT_Customer where customerid ="+customerId;	
			ResultSet rs = stmt.executeQuery(Sql);

			while (rs.next()) {

				cust=new Customer();
				cust.setCustomerID( rs.getInt("customerId"));	
				cust.setName(rs.getString("name"));
			}
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return cust;
	}
}
