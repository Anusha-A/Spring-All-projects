package com.customer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.dao.CustomerDAO;
import com.customer.dao.CustomerDAOImpl;
import com.customer.model.Customer;
/**
 * Servlet implementation class AddCustomerServlet
 */
public class AddCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String name;
	private String type;
	private int cust_id;
	private List<String> errors;
	private CustomerDAO dao = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		errors = new ArrayList<String>();
		
		String cid = request.getParameter("cust_id");
		try {
			cust_id = Integer.parseInt(cid);
		}
		 catch (Exception e) {
			// TODO: handle exception
			errors.add("year field must be numeric");
		}
		name = request.getParameter("name");
		if(name.length()<2)
		{
			errors.add("Inavlid name");
		}
				
		type=request.getParameter("type");
		if(type.equals("Unknown"))
		{
			errors.add("select a cust type");
		}
		if(!errors.isEmpty())
		{
			request.setAttribute("ERROR",errors);
			RequestDispatcher view=request.getRequestDispatcher("add_customer_servlet.view");
			view.forward(request, response);
		}
		else
		{
			Customer l = new Customer(name, cust_id, type);
			request.setAttribute("SUCCESS", l);
			dao = new CustomerDAOImpl();
			dao.createCustomer(l);
			RequestDispatcher view = request.getRequestDispatcher("add_customer_servlet.view");
			view.forward(request, response);
		}
	}


}
