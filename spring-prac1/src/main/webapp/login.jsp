<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color="red">${message}</font>
<form action="${pageContext.request.contextPath}/<core:url value='j_spring_security_check'/>" method="post">
Mail Id : <input type="text" name ="mail"/></br>
Password : <input type="password" name="pwd"/></br>
<input type="submit" value="Login"/>
</form>
</body>
</html>