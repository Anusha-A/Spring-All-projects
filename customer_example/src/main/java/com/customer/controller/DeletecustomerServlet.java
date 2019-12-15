package com.customer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.customer.dao.CustomerDAO;
import com.customer.dao.CustomerDAOImpl;
import com.customer.model.Customer;

/**
 * Servlet implementation class DeletecustomerServlet
 */
public class DeletecustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CustomerDAO dao = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletecustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int cust_id = (Integer)request.getAttribute("cust_ID");
	dao = new CustomerDAOImpl();
	dao.deleteRow(cust_id);
	RequestDispatcher view = request.getRequestDispatcher("add_customer_servlet.view");
	view.forward(request, response);
	}
}
