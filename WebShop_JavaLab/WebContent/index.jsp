<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<h1>User Login</h1>
	
	 <form action="<%= request.getContextPath() %>/login" method="post">
		<table style="with: 80%">
		    <tr>
		     <td>User Name</td>
		     <td><input type="text" name="user_name" /></td>
		    </tr>
		    <tr>
		     <td>Password</td>
		     <td><input type="password" name="user_password" /></td>
		    </tr>
    	</table>
		<input type="submit" value="Submit" />
	 </form>
	 
	<form action="userregistration.jsp">
		<input type = "submit" value="click" />
	</form>
</div>
</body>
</html>