<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function deleteUser(mail){
	alert(mail);
	alert("deleteUser function triggered!!");
	document.forms[0].action="deleteUser?mailId="+mail;
	document.forms[0].method="post";
	document.forms[0].submit();
}
function openInEditView(mail){
	alert(mail);
	alert("Opening "+ mail +" in edit view");
	document.form1.action="openInEditView?mailId="+mail;
	document.form1.method="post";
	document.form1.submit();
}
</script>
<body>

<%-- 	Mail  ||  Name  || Mobile Number || Password</br>
<core:forEach var="emp" items="${empList}">
    ${emp.mail} || ${emp.name} || ${emp.mbl} || ${emp.pwd}</br>
</core:forEach> --%>


<a href='<core:url value="j_spring_security_logout" />' > Logout</a></br>
<form name="form1" id="form1" action="">
<table border="2" >
<tr>
	<th>Mail</th>
	<th>Name</th>
	<th>Mobile Number</th>
	<th>Password</th>
</tr>
<core:forEach var="emp" items="${empList}">
	<tr>
    	<td>${emp.mail}</td>
    	<td>${emp.name}</td>
    	<td>${emp.mbl}</td>
    	<td>${emp.pwd}</td>
    	<td><input type="button" onclick="deleteUser('${emp.mail}')" value="Delete"/></td>
    	<td><input type="button" onclick="openInEditView('${emp.mail}')" value="Edit"/> </td>
	</tr>
</core:forEach>
</table>
</form>
</body>
</html>