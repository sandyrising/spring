<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updateUser" method="post">
Name : <input type="text" name="name" value="${empl.name}" /></br>
Mobile Number : <input type="text" name="mbl" value="${empl.mbl}"/><br>
Mail Id : <input type="text" name="mail" value="${empl.mail}"/></br>
City Name : <input type="text" name="city" value="${empl.city}"/></br>
Password : <input type="password" name="pwd" value="${empl.pwd}"/></br>
Salary : <input type="text" name ="sal" value="${empl.sal}"/></br>
Company : <input type="text" name="comp" value="${empl.comp}"/></br>
<input type="submit" value="Update"/></br>
</form>
</body>
</html>