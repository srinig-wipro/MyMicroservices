package com.bank.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.bean.Account;
import com.bank.service.AccountService;

@WebServlet("/FundTransferServlet")
public class FundTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FundTransferServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/TransferFunds.jsp");
		rd.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String transferResponse="ERROR";

				
				int from=Integer.parseInt(request.getParameter("from"));
				int to=Integer.parseInt(request.getParameter("to"));
				int amount=Integer.parseInt(request.getParameter("amount"));
				
				if(from>0 && to>0) {
					transferResponse=new AccountService().transferFunds(from, to, amount);
					
					if(transferResponse.equals("SUCCESS")){						
						request.setAttribute("msg", transferResponse); 
						request.setAttribute("successMsg", "Fund Transfer Successfully Complete!! Transfer Fund from Account #: "
										+from+" to Account#: "+to
										+". Latest balance in your account "
										+new AccountService().getBalanceOf(from).getBalance()
										);
						
//						request.setAttribute("code", "Some thing went wrong");
					}else {
						request.setAttribute("msg", transferResponse); 
						request.setAttribute("errorMsg", "Ohh!! Unable to transfer funds - From Account# "
								+from+" to Account#: "+to
								+"...Reason could be "+transferResponse								
								);
					}
				}

	RequestDispatcher rd = getServletContext()
			.getRequestDispatcher("/pages/TransferFunds.jsp");
	rd.include(request,response);

	
}

}
