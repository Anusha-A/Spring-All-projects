package com.example.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.model.Customer;


@WebServlet("/updatecustomer.do")
public class UpdateCustomer extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private CustomerDao dao;
	private List<String> errors = null; 

	@Override
	public void init() throws ServletException {
		dao = new CustomerDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String sid;
		String firstName;
		String lastName;
		String email;
		errors = new ArrayList<String>(); //create an instance of list
		firstName = request.getParameter("firstName").toString();
		if((firstName == null) || (firstName.length() < 5)) {
			errors.add("first name should have Atleast 5 characters");
		}
		
		
		
		lastName = request.getParameter("lastName").toString();
		if((firstName == null) || (firstName.length() < 5)) {
			errors.add("last name should have Atleast 5 characters");
		}
		
		email = request.getParameter("email").toString();
		
		if(!errors.isEmpty()) {
			request.setAttribute("ERRORS", errors);
			RequestDispatcher view = request.getRequestDispatcher("customer_update.jsp");
			view.forward(request, response);
		}
		else {
			CustomerDao dao= new CustomerDaoImpl(); 
			sid = request.getParameter("customerId").toString();
			firstName = request.getParameter("firstName");
			int id = Integer.parseInt(sid);
			Customer c = dao.getCustomerById(id);
			c.setFirstName(firstName);
			c.setLastName(lastName);
			c.setEmail(email);
			dao.editCustomer(c);
			RequestDispatcher view = request.getRequestDispatcher("list.do");
			view.forward(request, response);
		}
		
		
	}
		

}
