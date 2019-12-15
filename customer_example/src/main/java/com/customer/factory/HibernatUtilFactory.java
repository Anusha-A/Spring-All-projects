package com.customer.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.customer.model.Customer;

public class HibernatUtilFactory {
	private static SessionFactory factory;
	public static SessionFactory getSessionFactory()
	{
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).buildSessionFactory();
		return factory;
	}
}
