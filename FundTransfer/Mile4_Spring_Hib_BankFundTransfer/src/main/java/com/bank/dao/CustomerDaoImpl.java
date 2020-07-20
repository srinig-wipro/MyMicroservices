package com.bank.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.bean.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {
	private static Logger logger = Logger.getLogger("com.bank.dao.CustomerDaoImpl");

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Customer saveCustomer(Customer cust) {
		if (cust != null) {
			try {
				sessionFactory.getCurrentSession().save(cust);
				System.out.println("!!!!!!!!!");

			} catch (Exception e) {
				logger.log(Level.WARNING, "Exception caught", e);
			}		}
		return cust;
	}

	@Override
	public List<Customer> findAllCustomers() {
		return (List<Customer>) sessionFactory.getCurrentSession().createCriteria(Customer.class).list();
	}

	@Override
	public Customer findCustomerByID(int customerId) {
		Customer cust=null;
		try{
			cust=(Customer)sessionFactory.getCurrentSession().get(Customer.class,customerId);
		}
		catch(Exception e){
			logger.log(Level.WARNING, "Exception caught", e);
		}
		
		return cust;
	}

}
