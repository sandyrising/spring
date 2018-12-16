<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<script type="text/javascript">
function registerUser() {
	alert("Triggered registerUser");
	document.forms[0].action="registerUser";
	document.forms[0].method="post";
	document.forms[0].submit();
	
	alert("Exist from registerUser");
}

function registerEmployee() {
	alert("Triggered registerEmployee");
	
	
	alert("Exist from registerEmployee");
}
</script>
<body>
<img alt="whats app" src="https://cdn.wccftech.com/wp-content/uploads/2018/04/whatsapp-request-your-info.jpg" width="400" height="200"/>
<font color="red">${message}</font>
<form action="registerUser">
Name : <input type="text" name="name" value="${emp.name}" /></br>
Mobile Number : <input type="text" name="mbl" value="${emp.mbl}"/><br>
Mail Id : <input type="text" name="mail" value="${emp.mail}"/></br>
City Name : <input type="text" name="city" value="${emp.city}"/></br>
Password : <input type="password" name="pwd" value="${emp.pwd}"/></br>
Salary : <input type="text" name ="sal" value="${emp.sal}"/></br>
Company : <input type="text" name="comp" value="${emp.comp}"/></br>
<input type="button" value="Register" onclick="registerUser()" ></br>
<a href="login.jsp">Click Here</a> to login
</form>
</body>
</html>