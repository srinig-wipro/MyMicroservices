package com.wipro.bank.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.bank.bean.Account;
import com.wipro.bank.bean.Customer;
import com.wipro.bank.service.AccountService;

@WebServlet("/getAccountOrCustomer")
public class GetAllCustomerOrAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	AccountService service;

	public GetAllCustomerOrAccount() {
		service = new AccountService();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String val = req.getParameter("select");
		//System.out.println(val);
		String msg = "";
		if(val.equals("account")) {
			try {
				List<Account> accList=service.getAllAccounts();
				for(Account acc:accList) {
					msg+=acc+"\r\n";
					
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				msg=e.getLocalizedMessage();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				msg=e.getLocalizedMessage();
			}
			
		}
		if(val.equals("customer")) {
			try {
				List<Customer> custList=service.getAllCustomers();
				for(Customer cust:custList) {
					msg+=cust +"\r\n";
					
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				msg=e.getLocalizedMessage();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				msg=e.getLocalizedMessage();
			}
			
		}
		RequestDispatcher rd = req.getRequestDispatcher("GeneralResponse.jsp");
		req.setAttribute("message", msg);
		rd.forward(req, resp);

	}

}// NewCustomerServlet
