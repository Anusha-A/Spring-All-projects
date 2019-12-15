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

import com.example.dao.CustomerDaoImpl;
import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.model.Customer;

@WebServlet("/save.do")
public class SaveCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Customer> list;
	private CustomerDao dao;
	private String firstname;
	private String lastname;
	private String email;
	private List<String> errors;
	

	@Override
	public void init() throws ServletException {
		dao = new CustomerDaoImpl();
	}

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
		String fName=request.getParameter("firstName");
		String lName=request.getParameter("lastName");
		String email=request.getParameter("email");
		dao.createCustomer(new Customer(fName, lName, email));
		RequestDispatcher view=request.getRequestDispatcher("list.do");
		view.forward(request, response);

	}
}
