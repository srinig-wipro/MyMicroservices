package ap.ilp1.FundTransfer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import ap.ilp1.FundTransfer.dao.AccountDAO;
import ap.ilp1.FundTransfer.dao.CustomerDAO;
import ap.ilp1.FundTransfer.entity.Account;
import ap.ilp1.FundTransfer.entity.Customer;
import ap.ilp1.FundTransfer.service.AccountService;

@SpringBootApplication
public class FundTransferApplication implements CommandLineRunner{
	@Autowired
	AccountService accservice;
	
	@Autowired
	CustomerDAO custdao;
	
	@Autowired
	AccountDAO accdao;


	public static void main(String[] args) {
		SpringApplication.run(FundTransferApplication.class, args);
	}

	
	@Override
    public void run(String... arg0) throws Exception {
    	clearData();
    	saveData();
    	System.out.println("***********");
    	showData();
    }
	
	
	 @Transactional
	    private void clearData(){
		 accdao.deleteAll();
		 custdao.deleteAll();
	    }
	 
	 @Transactional
	    private void saveData(){
	    	saveDataWithApproach1();
	        // saveDataWithApproach2();
	    }
	 
	 /**
	     * Save Customer objects that include Account list
	     */
	    private void saveDataWithApproach1(){
			Customer cust0 = new Customer("custA0");
			Account acc0 = new Account(cust0, 645.8);
			cust0.getCustomerAccounts().add(acc0);
			
			Customer cust1 = new Customer("custA1");
			Account acc1 = new Account(cust1, 645.8);
			cust1.getCustomerAccounts().add(acc1);
	
	        
	        // save customers with their account
			custdao.save(cust0);
			custdao.save(cust1);
	    }
	    
	    @Transactional
	    private void showData(){
	    	// get All data
	    	List<Customer> customers = custdao.findAll();
	        List<Account> accounts = accdao.findAll();
	         
	        System.out.println("===================Product List:==================");
	        System.out.println(accounts.size());
	        accounts.forEach(System.out::println);
	         
	        System.out.println("===================Company List:==================");
	        customers.forEach(System.out::println);
	    }
	    
	    
//	@Bean
//	CommandLineRunner Myrun() {
//		System.out.println("########");
//		return (args) -> {
//			System.out.println("!!!!!!!!!!");
//			Customer cust0 = new Customer("cust0");
//			Account acc1 = new Account(cust0, 645.8);
//			cust0.getCustomerAccounts().add(acc1);
//			
//			custdao.save(cust0);
//			
//			List<Account> as = accservice.getAllAccounts();
//			System.out.println(as.size());
//
//			
////			for (Account a : as) {
////				System.out
////						.println("Fetch Result: " + a.getId() + " - " + a.getCustomer().getName() + "- " + a.getBalance());
////			}
//
//		};
//	}

//	List<Account> accounts=new ArrayList<Account>();
//	
//	Account acc1=new Account(1,new Customer(1,"cust1"),100.0);
//	Account acc2=new Account(2,new Customer(2,"cust2"),0.0);
//	
//	Account acc4=new Account(4,new Customer(4,"cust4"),123.0);
//	Account acc5=new Account(5,new Customer(5,"cust5"),984.0);
//	
//	accounts.add(acc1);
//	accounts.add(acc2);
//	accounts.add(acc4);
//	accounts.add(acc5);
//	
////	AccountDAO.defineDB(accounts);
////	AccountService process=new AccountService();
////	
////	System.out.println("************** Get All Accounts *****************");
////	System.out.println(process.getAllAccounts());
////	System.out.println("\n************** Get All Customers *****************");
////	System.out.println(process.getAllCustomers());
////	
////	
////	Account userTest1=process.getBalanceOf(acc1.getAccountID());
////	System.out.println("\n@ Account  details of account number:"+acc1.getAccountID()+" is :"+"\n## "+userTest1);
////	
////	userTest1=process.getBalanceOf(acc4.getAccountID());
////	System.out.println("\n@ Account  details of account number:"+acc4.getAccountID()+" is as follows"+"\n## "+userTest1);
////	
////	System.out.println("\n########## Account Balance for given account number ##########");
////	Account userTest2=process.getBalanceOf(3);
////	System.out.println("@ Account  details of account number:3 .."+"##  "+userTest2+"  sorry user doesn't exist\n");	
////	
////	System.out.println("############ All Customer Details ############");		
////	System.out.println(process.getAllCustomers());
////	
////	System.out.println("\n ############ Transfer of Funds from account number 4 to 5 ############");		
////	String transferStatus=process.transferFunds(4,5,100);
////	System.out.println("@ Fund Transfer from account 4 to account 5 is: "+transferStatus);	
////
////	transferStatus=process.transferFunds(4,5,100);
////	System.out.println("@ Response of fund transfer when funds are in sufficient : "+transferStatus);
////	
////	userTest1=process.getBalanceOf(4);
////	System.out.println("@ Available balance for account number: 4 is"+"\n## "+userTest1);
////	
////	userTest1=process.getBalanceOf(5);
////	System.out.println("@ Account details of account number: 5 is"+"\n## "+userTest1);
////	
////	System.out.println("*******************************************************\n");
////	Customer cust3=new Customer(3,"cust3");
////	Account acc3=new Account(9,cust3,0.0);
////	System.out.println("New Customer & Account created: "+process.addAccount(acc3));
////	System.out.println("\n************** Get All Customers *****************");
////	System.out.println(process.getAllCustomers());
//	

}
