<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<H3>WELCOME TO EMPLOYEE REGISTER PAGE!!</H3>
<form action="save" method="POST">
<pre>
NAME   : <input type="text" name="ename"/>
EMAIL  : <input type="text" name="email"/>
SALARY : <input type="text" name="esal"/>
DEPT   : <select name="dept">
			<option value="">-SELECT-</option>
			<option value="DEV">DEV</option>
			<option value="QA">QA</option>
			<option value="BA">BA</option>
		</select>
		
   <input type="submit" value="Add Employee"/>
</pre>
</form>
${msg}
</body>
</html>