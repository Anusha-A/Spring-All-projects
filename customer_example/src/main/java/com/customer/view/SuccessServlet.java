package com.customer.view;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.customer.model.Customer;

import org.hibernate.Query;

import org.hibernate.Transaction;


/**
 * Servlet implementation class SuccessServlet
 */
public class SuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuccessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Object obj = request.getAttribute("SUCCESS");
		Customer c=(Customer)obj;
		out.println("Customer added: "+c.getName()+" "+c.getCust_id()+""+c.getType());
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			 Transaction t = session.beginTransaction();

		        Query query = session.createQuery("from customer");
		       List list = query.list();
		        System.out.println(list);
		        t.commit();
		        session.close();

			System.out.println("Done!");
		} finally {

			session.close();

			factory.close();
		}
	}

}
