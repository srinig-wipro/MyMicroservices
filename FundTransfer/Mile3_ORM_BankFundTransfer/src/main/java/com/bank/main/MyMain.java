package com.bank.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;

import com.bank.bean.Account;
import com.bank.bean.Customer;
import com.bank.dao.AccountDaoDB;
import com.bank.service.AccountService;
import com.bank.util.DBUtil;
import com.bank.util.HibernateUtil;

public class MyMain {
	public static void main(String[] args) {
		List<Account> accounts=new ArrayList<Account>();
		
		new MyMain().runHiberanteTest();
		new MyMain().runJPAtest();
		
		
//		Account acc1=new Account(1,new Customer(1,"cust1"),100.0);
//		Account acc2=new Account(2,new Customer(2,"cust2"),0.0);
//		Account acc4=new Account(4,new Customer(4,"cust4"),123.0);
//		Account acc5=new Account(5,new Customer(5,"cust5"),984.0);
//		accounts.add(acc1);
//		accounts.add(acc2);
//		accounts.add(acc4);
//		accounts.add(acc5);
//		
//		DBUtil.defineDB(accounts);
//		
//		AccountService process=new AccountService();
//		System.out.println("************** Get All Accounts *****************");
//		System.out.println(process.getAllAccounts().values());
//		System.out.println("\n************** Get All Customers *****************");
//		System.out.println(process.getAllCustomers());
//		Account userTest1=process.getBalanceOf(acc1.getAccountID());
//		System.out.println("\n@ Account details of account number:"+acc1.getAccountID()+" is :"+"\n## "+userTest1);
//		
//		userTest1=process.getBalanceOf(acc4.getAccountID());
//		System.out.println("\n@ Account details of account number:"+acc4.getAccountID()+" is as follows"+"\n##"+userTest1);
//		System.out.println("\n########## Account Balance for given account number ##########");
//		Account userTest2=process.getBalanceOf(3);
//		System.out.println("@ Account details of account number:3 .."+"## "+userTest2+" sorry user doesn't exist\n");
//		
//		System.out.println("############ All Customer Details ############");
//		System.out.println(process.getAllCustomers());
//		
//		System.out.println("\n ############ Transfer of Funds from account number 4 to 5 ############");
//		String transferStatus=process.transferFunds(4,5,100);
//		System.out.println("@ Fund Transfer from account 4 to account 5 is: "+transferStatus);
//		transferStatus=process.transferFunds(4,5,100);
//		System.out.println("@ Response of fund transfer when funds are in sufficient : "+transferStatus);
//		userTest1=process.getBalanceOf(4);
//		System.out.println("@ Available balance for account number: 4 is"+"\n## "+userTest1);
//		userTest1=process.getBalanceOf(5);
//		System.out.println("@ Account details of account number: 5 is"+"\n## "+userTest1);
//		System.out.println("*******************************************************\n");
//		Customer cust3=new Customer(3,"cust3");
//		Account acc3=new Account(9,cust3,0.0);
//		System.out.println("New Customer & Account created: "+process.addAccount(acc3));
//		System.out.println("\n************** Get All Customers *****************");
//		System.out.println(process.getAllCustomers());
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$$");

			
		}
	
	Connection getMySqlConnection() {
		String JDBC_DRIVER="com.mysql.jdbc.Driver";
		 String connectionUrl = "jdbc:mysql://localhost:3306/devops";
	        String username="devops";
	        String password="devops";
	        Connection con=null;

	        try {
	        	Class.forName(JDBC_DRIVER);
				con=DriverManager.getConnection(connectionUrl,username,password);
				//System.out.println(con +"Connection Established");
	        }
	        // Handle any errors that may have occurred.
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        return con;
		
	}
	
	Connection getH2Connection() {
		String JDBC_DRIVER="org.h2.Driver";
		 String connectionUrl = "jdbc:h2:~/test";
	        String username="sa";
	        String password="";
	        Connection con=null;

	        try {
	        	Class.forName(JDBC_DRIVER);
				con=DriverManager.getConnection(connectionUrl,username,password);
				System.out.println(con +"Connection Established");
	        }
	        // Handle any errors that may have occurred.
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        return con;		
	}
	
	void runHiberanteTest() {
		System.out.println("Maven + Hibernate (ORM) Annotation /cfg + MySql");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Account acc1=new Account();
		Customer cust1=new Customer();
		cust1.setName("Customer1");
		acc1.setCustomer(cust1);
		acc1.setBalance(123.4);

		session.save(cust1);
		session.save(acc1);
		session.getTransaction().commit();
		
      List<Account> list = null;
      list = session.createNamedQuery("Employee.findAll").getResultList();
    		  //createCriteria(Account.class).list();
      System.out.println("Get all records: "+list);
		System.out.println("### Program Ends here ###");
	}
	
	void runJPAtest() {
		
		System.out.println("Maven + JPA Persistency + H2");
		 String PERSISTENCE_UNIT_NAME = "demojpa";

	    EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);		
        EntityManager em = factory.createEntityManager();
        
        System.out.println("Emtity Manager created.."+em);
     // Begin a new local transaction so that we can persist a new entity
        em.getTransaction().begin();
        
            
            Account acct = new Account();
            Customer cust=new Customer();
            cust.setName("Patel");
            acct.setCustomer(cust);
            acct.setBalance(123.4);
            em.persist(cust);
            em.persist(acct);
            em.getTransaction().commit();
            

           List<Account> accounts =  em.createNamedQuery("Employee.findAll").getResultList();
        		   //em.createQuery("SELECT a FROM Account a").getResultList();
           for(Account a:accounts) {
        	   System.out.println(a);
           }
           
        


        em.close();
	}
}
