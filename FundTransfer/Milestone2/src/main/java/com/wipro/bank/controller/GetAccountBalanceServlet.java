package com.wipro.bank.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.bank.service.AccountService;

@WebServlet("/getBalance")
public class GetAccountBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountService service;

	public GetAccountBalanceServlet() {
		// TODO Auto-generated constructor stub
	service=new AccountService();
	
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int accountNumber = Integer.parseInt(req.getParameter("accountNumber"));
		String msg=null;
		try {
			double amt=service.getBalanceOf(accountNumber);
			msg="Total Amount in Acc :"+accountNumber+" is Rs "+amt;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg=e.getLocalizedMessage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg=e.getLocalizedMessage();
		}
		
		
		RequestDispatcher rd = req.getRequestDispatcher("GeneralResponse.jsp");
		req.setAttribute("message", msg);
		rd.forward(req, resp);
	}
}
