<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
   

 
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>
		<strong>Shopping Cart</strong>
	</p>
	<p>
		<a href="view_menu.jsp">Model List</a>
	</p>
	<table width="75%" border="1">
		<tr>
			<td><strong>Model Description</strong></td>
			<td><strong>Quantity</strong></td>
			<td><strong>Unit Price</strong></td>
			<td><strong>Total</strong></td>
		</tr>
		<jsp:useBean id="cart" scope="session" class="comm.example.bean.CartBean" />
		<c:if test="${cart.lineItemCount==0}">
			<tr>
				<td colspan="4">- Cart is currently empty -<br />
			</tr>
		</c:if>
		<c:forEach var="cartItem" items="${cart.cartItems}" varStatus="counter">
			<form name="item" method="POST" action="cardController.do">
				<tr>
					<td><b><c:out value="${cartItem.partNumber}" /></b><br /> <c:out
							value="${cartItem.modelDescription}" /></td>
					<td><input type='hidden' name='itemIndex'
						value='<c:out value="${counter.count}"/>'> <input
						type='text' name="quantity"
						value='<c:out value="${cartItem.quantity}"/>'> <input
						type="submit" name="action" value="Update"><input
						type="submit" name="action" value="Delete"></td>
					<td>$<c:out value="${cartItem.unitCost}" /></td>
					<td>$<c:out value="${cartItem.totalCost}" /></td>
				</tr>
			</form>
		</c:forEach>

		<tr>
			<td colspan="2"></td>
			<td></td>
			<td>Subtotal: $<c:out value="${cart.orderTotal}" />
			</td>
		</tr>
	</table>

</body>
</html>