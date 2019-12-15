package com.customer.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;

import com.customer.factory.HibernatUtilFactory;
import com.customer.model.Customer;





public class CustomerDAOImpl implements CustomerDAO {
	private Session session = null;
	private SessionFactory factory = null;

	{
		factory = HibernatUtilFactory.getSessionFactory();
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
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
	List<Customer> list=null;
		try {
			session=factory.openSession();
			session.getTransaction().begin();
			list=session.createQuery("from Customer").getResultList();
		} finally {
			session.close();
		}
		
		return list;
	}
	public void deleteRow(int id)
	{
		try {
		session=factory.openSession();
		session.getTransaction().begin();
		Customer cm=session.get(Customer.class, id);
		if(cm!=null)
		{
			session.delete(cm);
			System.out.println("deleted sucessfully..");
			session.getTransaction().commit();
		}
		
		else
		{
			System.out.println("no such record found.");
		}
		}
		finally {
			session.close();
		}
	}
	
}
