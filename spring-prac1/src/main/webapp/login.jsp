<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color="red">${message}</font>
<form action="loginUser">
Mail Id : <input type="text" name ="mail"/></br>
Password : <input type="password" name="pwd"/></br>
<input type="submit" value="Login"/>
</form>
</body>
</html>