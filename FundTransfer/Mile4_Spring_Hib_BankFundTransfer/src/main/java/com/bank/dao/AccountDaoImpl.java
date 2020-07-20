package com.bank.dao;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.bean.Account;
import com.bank.bean.Customer;
@Repository
public class AccountDaoImpl implements AccountDao {
	private static Logger logger = Logger.getLogger("com.bank.dao.AccountDaoImpl");
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Account saveAccount(Account acct) {
		if (acct != null) {
			try {
				sessionFactory.getCurrentSession().save(acct);
				System.out.println("!!!!!!!!!");

			} catch (Exception e) {
				logger.log(Level.WARNING, "Exception caught", e);
			}
		}
		return acct;
	}

	@Override
	public Map<Integer, Account> findAllAccounts() {
		Map<Integer, Account> accountCustomers = new HashMap<Integer, Account>();
		List<Account> accounts = sessionFactory.getCurrentSession().createCriteria(Account.class).list();
		for (Account a : accounts) {
			accountCustomers.put(a.getAccountID(), a);
		}

		return accountCustomers;
	}

	@Override
	public Account findAccountByID(int accountId) {
		Account acct = null;
		try {
			acct = (Account) sessionFactory.getCurrentSession().get(Account.class, accountId);
		} catch (Exception e) {
			logger.log(Level.WARNING, "Exception caught", e);
		}

		return acct;
	}

	@Override
	public boolean updateAccount(int accountId, double balance) {
		Account a = new Account();
		sessionFactory.getCurrentSession().saveOrUpdate(a);
		return true;
	}

//	public long getId(String seq) {
//		long key = 0L;
//	
//		Connection connection = sessionFactory.getCurrentSession().connection();
//		try {
//			Statement stmt = connection.createStatement();
//			ResultSet rs = stmt.executeQuery("select "+seq+".nextval ");
//			if (rs.next()) {
//				key = Long.parseLong(rs.getString(1));
//
//			}
//		} catch (NumberFormatException eNumf) {
//			logger.log(Level.WARNING, "NumberFormatException caught", eNumf);
//
//		} catch (SQLException eSQL) {
//			logger.log(Level.WARNING, "SQLException caught", eSQL);
//		}
//
//		finally {
//
//			try {
//				connection.close();
//			} catch (SQLException e) {
//				logger.log(Level.WARNING, "SQLException caught", e);
//
//			}
//		}
//		return key;
//
//	}

}
