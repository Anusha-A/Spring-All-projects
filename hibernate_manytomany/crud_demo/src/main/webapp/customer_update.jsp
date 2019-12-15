<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>

	
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer</h3>
	
		<form action="updatecustomer.do" method="POST">
		
		
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><input name="firstName" type="text" value="${customer.firstName }" /></td>
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><input name="lastName" type="text" value="${customer.lastName}"/></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input name="email" type="text" value="${customer.email}"/></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Update" class="save" /></td>
					</tr>
					<input type="hidden" id="Id" name="customerId" value=<%= request.getParameter("customerId") %>>

				
				</tbody>
			</table>
		
		
		</form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="list.do">Back to List</a>
		</p>
	
	</div>

</body>

</html>