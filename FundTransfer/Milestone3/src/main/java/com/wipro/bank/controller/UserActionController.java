package com.wipro.bank.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.wipro.bank.bean.Account;
import com.wipro.bank.bean.Customer;
import com.wipro.bank.service.AccountService;

@Controller
public class UserActionController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="pages/createAccount", method = RequestMethod.POST)
	public ModelAndView createAccount(ModelMap model, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView();
		String name=request.getParameter("name");
		String amount=request.getParameter("amount");
		int accountId = accountService.createAccount(name, Integer.parseInt(amount));
		if(accountId > 0)
			model.addAttribute("message", "Your account "+ accountId +" created successfully!");
		else
			model.addAttribute("message", "A problem occured while creating account! Please check the server logs...");
		mav.setViewName("GeneralResponse");
		return mav;
	}
	
	
	@RequestMapping(value="pages/searchAccount", method = RequestMethod.POST)
	public ModelAndView searchAccount(ModelMap model, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView();
		String accountId = request.getParameter("accountId");
		Account account = accountService.getAccountdetails(Integer.parseInt(accountId));
		
		List<Account> accountLst = new ArrayList<>();
		
		if(account != null) {
			accountLst.add(account);
			model.addAttribute("message", "Here is the account details !");
		} else
			model.addAttribute("message", "No data found for given account ID!");

		mav.setViewName("GeneralResponse");
		mav.addObject("lists", accountLst);
		return mav;
	}
	
	@RequestMapping(value="pages/displayAllAccounts", method = RequestMethod.POST)
	public ModelAndView displayAllAccounts(ModelMap model, HttpServletRequest request) throws Exception{
		List<Account> accountLst = accountService.getAllAccountdetails();
		ModelAndView mav = new ModelAndView();
		if(accountLst.size() > 0)
			model.addAttribute("message", "Here is the account details !");
		else
			model.addAttribute("message", "No data found!");
		mav.setViewName("GeneralResponse");
		mav.addObject("lists", accountLst);
		return mav;
	}
	
	@RequestMapping(value="pages/displayAllCustomers", method = RequestMethod.POST)
	public ModelAndView displayAllCustomers(ModelMap model, HttpServletRequest request) throws Exception{
		ModelAndView mav = new ModelAndView();
		List<Customer> customerLst = accountService.getAllCustomerDetails();
		if(customerLst.size() > 0)
			model.addAttribute("message", "Here is the customer details !");
		else
			model.addAttribute("message", "No data found!");
		mav.setViewName("GeneralResponse");
		mav.addObject("lists", customerLst);
		return mav;
	}
	
	@RequestMapping(value="pages/transferFund", method = RequestMethod.POST)
	public ModelAndView transferFunds(ModelMap model, HttpServletRequest request) throws Exception{
		
		int fromAccountId = Integer.parseInt(request.getParameter("fromAccount"));
		int toAccountId = Integer.parseInt(request.getParameter("toAccount"));
		int transferAmount = Integer.parseInt(request.getParameter("amount"));
		String returnMessage = "";
		if(fromAccountId == toAccountId) {
			returnMessage =  "Fund can not be transferred to the same account!";
		} else {
			returnMessage = accountService.transferFunds(fromAccountId, toAccountId, transferAmount);
		}
		ModelAndView mav = new ModelAndView();
		model.addAttribute("message", returnMessage);
		mav.setViewName("GeneralResponse");
		return mav;
	}

}
