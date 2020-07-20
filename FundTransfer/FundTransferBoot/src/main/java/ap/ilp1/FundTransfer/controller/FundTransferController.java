package ap.ilp1.FundTransfer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ap.ilp1.FundTransfer.entity.Account;
import ap.ilp1.FundTransfer.entity.Customer;
import ap.ilp1.FundTransfer.service.AccountService;


@RestController
@RequestMapping("/bank")
public class FundTransferController {

	@Autowired
	AccountService accservice;
	
	 @GetMapping("/accounts")
	    public List<Account> getAllAccounts() {
	        return accservice.getAllAccounts();
	    }
	 
	 @GetMapping("/customers")
	    public List<Customer> getAllCustomers() {
	        return accservice.getAllCustomers();
	    }
}
