package com.customer.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.customer.model.Customer;

/**
 * Servlet implementation class ErrorServlet
 */
public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	@SuppressWarnings("unchecked")
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		@SuppressWarnings("unused")
		List<String> list=(List<String>)request.getAttribute("ERROR");
		out.println("Please correct the mentioned error<br/>");
		for(String str:list)
		{
			out.println("<font color='red'>"+str+"</font><br/>");
		}
		out.println("<a href='add_customer.html'>try again</a>");
	}



}
