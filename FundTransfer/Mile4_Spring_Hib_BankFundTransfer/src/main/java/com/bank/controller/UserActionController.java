package com.bank.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bank.bean.Account;
import com.bank.service.AcctountService;
import com.bank.service.xAccountServiceRef;

@Controller

public class UserActionController {

	@Autowired
	AcctountService accountService;
	
	@RequestMapping(value = "/Home", method = RequestMethod.GET)
	public ModelAndView getHomePage() {
		return new ModelAndView("Home");
	}

	@RequestMapping(value = "/getNewAccountForm", method = RequestMethod.GET)
	public ModelAndView getNewAccountForm(@ModelAttribute("account") Account acct, BindingResult result) {
		return new ModelAndView("CreateNewAccountForm");
	}
	
	@RequestMapping(value = "/getSearchByIdForm", method = RequestMethod.GET)
	public ModelAndView getSearchByIdForm(@ModelAttribute("account") Account acct, BindingResult result) {
		return new ModelAndView("CreateNewAccountForm");
	}
	
	@RequestMapping(value = "/getSearchAllAccountsForm", method = RequestMethod.GET)
	public ModelAndView getSearchAllAccountsForm(@ModelAttribute("account") Account acct, BindingResult result) {
		return new ModelAndView("CreateNewAccountForm");
	}
	
	@RequestMapping(value = "/getFundTransferForm", method = RequestMethod.GET)
	public ModelAndView getFundTransferForm(@ModelAttribute("account") Account acct, BindingResult result) {
		return new ModelAndView("CreateNewAccountForm");
	}
	
	
	

	@RequestMapping(value = "/AccountServlet", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("account") @Validated Account acct, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();

		if (result.hasErrors()) {
			return new ModelAndView("CreateNewAccountForm");
		} else {

			Account updatedAcct = accountService.addAccount(acct);
			model.put("msg", "Your account created successfully!");
			model.put("account", updatedAcct);

			return new ModelAndView("CreateNewAccountForm", model);
		}

	}

//	@RequestMapping(value="pages/createAccount", method = RequestMethod.POST)
//	public ModelAndView createAccount(ModelMap model, HttpServletRequest request) throws Exception{
//		ModelAndView mav = new ModelAndView();
//		String name=request.getParameter("name");
//		String amount=request.getParameter("amount");
//		int accountId = accountService.createAccount(name, Integer.parseInt(amount));
//		if(accountId > 0)
//			model.addAttribute("message", "Your account "+ accountId +" created successfully!");
//		else
//			model.addAttribute("message", "A problem occured while creating account! Please check the server logs...");
//		mav.setViewName("GeneralResponse");
//		return mav;
//	}
//	
//	
//	@RequestMapping(value="pages/searchAccount", method = RequestMethod.POST)
//	public ModelAndView searchAccount(ModelMap model, HttpServletRequest request) throws Exception{
//		ModelAndView mav = new ModelAndView();
//		String accountId = request.getParameter("accountId");
//		Account account = accountService.getAccountdetails(Integer.parseInt(accountId));
//		
//		List<Account> accountLst = new ArrayList<>();
//		
//		if(account != null) {
//			accountLst.add(account);
//			model.addAttribute("message", "Here is the account details !");
//		} else
//			model.addAttribute("message", "No data found for given account ID!");
//
//		mav.setViewName("GeneralResponse");
//		mav.addObject("lists", accountLst);
//		return mav;
//	}
//	
//	@RequestMapping(value="pages/displayAllAccounts", method = RequestMethod.POST)
//	public ModelAndView displayAllAccounts(ModelMap model, HttpServletRequest request) throws Exception{
//		List<Account> accountLst = accountService.getAllAccountdetails();
//		ModelAndView mav = new ModelAndView();
//		if(accountLst.size() > 0)
//			model.addAttribute("message", "Here is the account details !");
//		else
//			model.addAttribute("message", "No data found!");
//		mav.setViewName("GeneralResponse");
//		mav.addObject("lists", accountLst);
//		return mav;
//	}
//	
//	@RequestMapping(value="pages/displayAllCustomers", method = RequestMethod.POST)
//	public ModelAndView displayAllCustomers(ModelMap model, HttpServletRequest request) throws Exception{
//		ModelAndView mav = new ModelAndView();
//		List<Customer> customerLst = accountService.getAllCustomerDetails();
//		if(customerLst.size() > 0)
//			model.addAttribute("message", "Here is the customer details !");
//		else
//			model.addAttribute("message", "No data found!");
//		mav.setViewName("GeneralResponse");
//		mav.addObject("lists", customerLst);
//		return mav;
//	}
//	
//	@RequestMapping(value="pages/transferFund", method = RequestMethod.POST)
//	public ModelAndView transferFunds(ModelMap model, HttpServletRequest request) throws Exception{
//		
//		int fromAccountId = Integer.parseInt(request.getParameter("fromAccount"));
//		int toAccountId = Integer.parseInt(request.getParameter("toAccount"));
//		int transferAmount = Integer.parseInt(request.getParameter("amount"));
//		String returnMessage = "";
//		if(fromAccountId == toAccountId) {
//			returnMessage =  "Fund can not be transferred to the same account!";
//		} else {
//			returnMessage = accountService.transferFunds(fromAccountId, toAccountId, transferAmount);
//		}
//		ModelAndView mav = new ModelAndView();
//		model.addAttribute("message", returnMessage);
//		mav.setViewName("GeneralResponse");
//		return mav;
//	}

}
