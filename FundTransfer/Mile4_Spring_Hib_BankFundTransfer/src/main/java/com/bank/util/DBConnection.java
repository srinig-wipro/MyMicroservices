package com.bank.util;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class DBConnection {
	
	public static Session getDBSession() {
		Session session = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure()
                  .buildSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
		return session;
	}
	
	public static void closeDBSession(Session session) {
		try {
			session.getTransaction().commit();
			session.close();
		}catch(Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
	
	

}
