package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.CustomerDao;
import com.example.dao.CustomerDaoImpl;
import com.example.model.Customer;

public class ListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Customer> list;
	private CustomerDao dao;
	

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

		list=dao.getAllCustomer();
		request.setAttribute("customers", list);
		RequestDispatcher view=request.getRequestDispatcher("list-customer.jsp");
		view.forward(request, response);
	}

}