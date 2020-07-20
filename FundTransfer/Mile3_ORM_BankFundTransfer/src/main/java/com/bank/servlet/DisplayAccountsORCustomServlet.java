package com.bank.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.bean.Account;
import com.bank.bean.Customer;
import com.bank.dao.AccountDaoDB;
import com.bank.service.AccountService;

/**
 * Servlet implementation class DisplayAccountsORCustomServlet
 */
@WebServlet("/DisplayAccountsORCustomServlet")
public class DisplayAccountsORCustomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayAccountsORCustomServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/DisplayAccountsORCustomers.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/DisplayAccountsORCustomers.jsp");
		try {

			boolean flag = false;
			if (request.getParameter("details").equalsIgnoreCase("AD")) {
				
				Map<Integer, Account> listAccounts = new AccountService().getAllAccounts();
				List<Account> accounts = new ArrayList<Account>(listAccounts.values());
				//Collections accounts =  (Collections) listAccounts.values();

				request.setAttribute("msg", "AD");
				request.setAttribute("list", accounts);

			} else if (request.getParameter("details").equalsIgnoreCase("CD")) {
				
				List<Customer> listCustomers = new AccountService().getAllCustomers();
				System.out.println(listCustomers);
				request.setAttribute("msg", "CD");
				request.setAttribute("list", listCustomers);

			} else {
				System.out.println("Shouldn't be executed");
				request.setAttribute("msg", "notSuccess");
			}

		} catch (Exception e) {
			
			request.setAttribute("msg", "ER");
			request.setAttribute("code", e.getMessage());
		}
		rd.include(request, response);
	}
}