<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<%
		
		
	List<String> list=(List<String>)request.getAttribute("errors");
	if(list!=null)
	{
		for(String str:list)
		{
			System.out.println("<font color='red'>"+str+"<br/>");
		}
		System.out.println("</font>");
	}
	
	
	%>

<!-- Default form login -->
<form class="text-center border border-light p-5" action="save.do" method="post">

    <p class="h4 mb-4">Input Customer Details.</p>

    
    <input type="text" id="defaultLoginFormEmail" class="form-control mb-4" placeholder="Customer name" name="firstName">
     <input type="text" id="defaultLoginFormEmail" class="form-control mb-4" placeholder="Customer last name" name="lastName">
      <input type="text" id="defaultLoginFormEmail" class="form-control mb-4" placeholder="Customer email" name="email">

   

    <!-- Sign in button -->
    <button class="btn btn-info btn-block my-4" type="submit">Add A New Customer</button>


</form>

</body>
</html>