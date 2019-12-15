package com.customer.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.customer.dao.CustomerDAO;
import com.customer.dao.CustomerDAOImpl;
import com.customer.factory.HibernatUtilFactory;
import com.customer.model.Customer;

/**
 * Servlet implementation class addCustomerServlet
 */
public class addCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> l=null;
	private CustomerDAO dao = null;
	private String type=null;
	  private String[] typeArr;
	  private List<Customer> list = null;
	  
	  public void init(ServletConfig config) throws ServletException {
			// TODO Auto-generated method stub
			super.init(config);
			type=config.getInitParameter("customer-list");
			typeArr=type.split(",");
			
		}
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}

	@SuppressWarnings("unchecked")
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	l=(List<String>) request.getAttribute("ERROR");
	if(l!=null)
	{
		out.println("please correct the bellow error(s)<br/>");
		for(String str:l)
		{
			out.println("<font color='red'>"+str+"</font><br/>");
		}
	}
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<!-- Default form login -->\r\n" + 
				"<form class=\"text-center border border-light p-5\" action=\"add_customer.controller\" method=\"post\">\r\n" + 
				"\r\n" + 
				"    <p class=\"h4 mb-4\">Input League Details.</p>\r\n" + 
				"\r\n" + 
				"    \r\n" + 
				"    <input type=\"text\" id=\"defaultLoginFormEmail\" class=\"form-control mb-4\" placeholder=\"Customer ane\" name=\"name\">\r\n" + 
				"\r\n" + 
				"    \r\n" + 
				"    <input type=\"text\" id=\"defaultLoginFormPassword\" class=\"form-control mb-4\" placeholder=\"Customer id\" name=\"cust_id\">\r\n" + 
				"\r\n" );
		out.println("<select name='type'>");
		for(String str:typeArr) {
		
			out.println("<option value='"+str+"'>"+str+"</option>");
		}
		out.println("</select>");
				out.println("    <!-- Sign in button -->\r\n" + 
				"    <button class=\"btn btn-info btn-block my-4\" type=\"submit\">Add A New Customer</button>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</form>\r\n" ); 
				dao = new CustomerDAOImpl();
				list = dao.getAllCustomer();
				out.println("\"<form class=\"text-center border border-light p-5\" action=\"deletecustomer.controller\" method=\"post\">\r\n\"");
				out.println("<div class='container'><table border class='table'><tr><td>ID</td><td>Customer Name</td><td>Customer ID</td><td>Type</td></tr>");
				for(Customer c:list) {
					request.setAttribute("cust_ID", c.getId());
					out.println("<tr><td name=\"cust_id\">"+c.getId()+"</td><td >"+c.getName()+"</td><td>"+c.getCust_id()+"</td><td>"+c.getType()+"</td><td><button class=\"btn btn-info btn-block my-4\" type=\"submit\">Delete</button></td></tr>");
				}
				out.println("<div><table><a href='index.html'>Go to home page</a>");
				out.println("\r\n" + "</form>\r\n"+
				"</body>\r\n" + 
				"</html>");
	}

}
