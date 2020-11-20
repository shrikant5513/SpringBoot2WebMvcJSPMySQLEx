<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME TO EMPLOYEE DATA PAGE!!</h3>
<table border="1">
	<tr>
		<th>ID</th>
		<th>NAME</th>
		<th>MAIL</th>
		<th>SALARY</th>
		<th>DEPT</th>
		<th>HRA</th>
		<th>DA</th>
		<th>LINK</th>
		
	</tr>
	<c:forEach items="${list}" var="ob">
		<tr>
			<td>${ob.eid}</td>
			<td>${ob.ename}</td>
			<td>${ob.email}</td>
			<td>${ob.esal}</td>
			<td>${ob.dept}</td>
			<td>${ob.hra}</td>
			<td>${ob.da}</td>
			<td>
				<a href="delete?eid=${ob.eid}">DELETE</a> | 
				<a href="edit?eid=${ob.eid}">EDIT</a>
			</td>
		</tr>
	</c:forEach>
</table>
${message}
</body>
</html>