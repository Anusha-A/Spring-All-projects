<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="p" class="comm.example.model.User" scope="session"/>
<jsp:setProperty property="*" name="p"/>
User Name:<%=p.getuserName()%>
User Age:<%=p.getuserAge() %>
User Joining Year:<%=p.getJoiningYear() %>
User Release Year:<%=p.getReleaseYear() %>
<jsp:include page="controller.do"/>
</body>
</html>