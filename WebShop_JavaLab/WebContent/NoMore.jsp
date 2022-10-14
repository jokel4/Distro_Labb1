<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>Not enough of choosen item or items</h1></center>
<br>
<center><h2>Too few available items for you selection</h2></center>
<br>
<center><h2>Please try again with. Pay attention to the number of items left in stock</h2></center>
<br>
<center><form action="<%= request.getContextPath() %>/buy" method="post">
		<li><input type="submit" value="Buy" /></li>
		</form></center>

</body>
</html>