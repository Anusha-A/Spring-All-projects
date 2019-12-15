<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="processform" method="post" modelAttribute="employee">
FirstName:<form:input path="firstName"/><br/>
LastName:<form:input path="lastName"/><br/>
Salary:<form:input path="salary"/><br/>
<form:button type="submit">Submit Query</form:button>



</form:form>

</body>
</html>