package com.bank.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.bean.Account;
import com.bank.bean.Customer;
import com.bank.service.AccountService;

@WebServlet("/AccountServlet")
public class NewCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewCustomerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/CreateNewAccountForm.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" !!!!  AccountServlet - dopost !!!!");

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/CreateNewAccountForm.jsp");
		
		Account acct=new Account();
		Customer cust=new Customer();
		cust.setName(request.getParameter("customerName"));
		acct.setCustomer(cust);
		acct.setBalance(Double.parseDouble(request.getParameter("balance")));

		 acct=new AccountService().addAccount(acct);
		
		System.out.println("acct: "+acct);
		if(acct!=null) {			
			request.setAttribute("msg", "success");
			request.setAttribute("AccountNumber", acct.getAccountID());
			request.setAttribute("CustomerID", acct.getCustomer().getCustomerID());
			request.setAttribute("CustomerName", request.getParameter("customerName"));
		}else {
			request.setAttribute("msg", "error");
			request.setAttribute("error", "Something wrong with exceptions");
		}
		rd.include(request, response);
	}
}
