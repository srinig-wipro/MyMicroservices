package com.wipro.bank.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.bank.bean.Account;
import com.wipro.bank.bean.Customer;
import com.wipro.bank.service.AccountService;

@WebServlet("/addAccount")
public class NewCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static AccountService service;
	public NewCustomerServlet() {
		service=new AccountService();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Account acc=new Account();
		Customer cust=new Customer();
		String msg=null;
		acc.setAccountID(Integer.parseInt(req.getParameter("accountId")));
		cust.setCustomerID(Integer.parseInt(req.getParameter("customerId")));
		cust.setName(req.getParameter("customerName"));
		acc.setCustomer(cust);
		acc.setBalance(Float.parseFloat(req.getParameter("balance")));
		try {
			msg=service.addAccount(acc);
			//System.out.println(msg);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			msg=e.getLocalizedMessage();
		} catch (SQLException e) {
			e.printStackTrace();
			msg=e.getLocalizedMessage();
		}
		
		RequestDispatcher rd=req.getRequestDispatcher("GeneralResponse.jsp");
		req.setAttribute("message", msg);
		rd.forward(req, resp);
		
	}

}// NewCustomerServlet
