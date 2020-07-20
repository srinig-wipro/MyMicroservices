package com.bank.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.bean.Account;
import com.bank.service.AccountService;

/**
 * Servlet implementation class GetAccountBalance
 */
@WebServlet("/GetAccountBalance")
public class GetAccountBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetAccountBalanceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/getAccountBalance.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/getAccountBalance.jsp");
		
		try{
			int receivedid=Integer.parseInt(request.getParameter("accountID"));
			Account acct=new AccountService().getBalanceOf(receivedid);
			System.out.println(receivedid+"=== !!! ===: "+acct);
			if(acct!=null){
			
				request.setAttribute("msg", "success");
				request.setAttribute("AccountNumber", acct.getAccountID());
				request.setAttribute("CustomerID", acct.getCustomer().getCustomerID());
				request.setAttribute("CustomerName", acct.getCustomer().getName());	
				request.setAttribute("Balance", acct.getBalance());
			}else{

				request.setAttribute("msg", "NF");
				request.setAttribute("AccountNumber", request.getParameter("accountID"));
			}
			
		}catch (Exception e) {
			request.setAttribute("msg", "ER");
			request.setAttribute("code", e.getMessage());
		}
		
		rd.include(request, response);
	}
}
