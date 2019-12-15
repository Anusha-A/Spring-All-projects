package com.customer.view;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.dao.CustomerDAO;
import com.customer.model.Customer;
import com.customer.dao.CustomerDAOImpl;



/**
 * Servlet implementation class CustomerListServlet
 */
public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO dao = null;
       
	private List<Customer> list=null;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		dao = new CustomerDAOImpl();
		list = dao.getAllCustomer();
		out.println("<html><title>List All Available League</title><body><table border='1'><tr><td>Customer Name</td><td>ID</td><td>Type</td></tr>");
		for(Customer c:list)
		{
			out.println("<tr><td>"+c.getId()+"<td></td>"+c.getName()+"</td><td>"+c.getCust_id()+"</td><td>"+c.getType()+"</td></tr>");
		}
		out.println("</table><a href='index.html'>Go To Home Page</a></body></html>");
		
    	
	}


}
