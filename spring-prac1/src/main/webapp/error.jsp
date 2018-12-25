<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color="red"> ${message}</font></br>
Click Here for <a href="${pageContext.request.contextPath}/home">Home</a> Page </br>
Click Here for <a href="${pageContext.request.contextPath}/getAllEmployees">Show All</a> Employees
</body>
</html>