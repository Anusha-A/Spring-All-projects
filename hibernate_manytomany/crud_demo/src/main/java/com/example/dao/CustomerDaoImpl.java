package com.example.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.dao.CustomerDao;

import com.example.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	
	private SessionFactory factory = null;
	private Session session;

	{
		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();
	}
	public void createCustomer(Customer customer) {
		try {
			session = factory.openSession();
			session.getTransaction().begin();
			session.persist(customer);
			session.getTransaction().commit();

		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		session = factory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Customer", Customer.class);
		List<Customer> list = query.getResultList();
		session.getTransaction().commit();
		return list;
	}
	public void editCustomer(Customer customer) {
		try {session = factory.openSession();
		session.getTransaction().begin();
		session.update(customer);
		session.getTransaction().commit();}
		finally {
			session.close();
		}
		
	}
	
	@Override
	public void deleteCustomer(Customer customer) {
		session = factory.openSession();
		session.getTransaction().begin();
		session.delete(customer);
		session.getTransaction().commit();
		
	}
	public Customer getCustomerById(int id) {
		session = factory.openSession();
		session.getTransaction().begin();
		Customer c= session.get(Customer.class,id);
		return c;
	}
	@Override
	public List<Customer> findCustomer(String str) {
		// TODO Auto-generated method stub
		session = factory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("FROM Customer WHERE firstName like concat('%',:customerName,'%')");
        query.setParameter("customerName", str);
        session.getTransaction().commit();

		return query.getResultList();
	}

}
