<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<ul>
<li><a href="items.jsp">All Items</a></li>
<form action="<%= request.getContextPath() %>/shoppingCart" method="post">
<li><input type="submit" value="Shopping Cart" /></li>
</form>
<form action="<%= request.getContextPath() %>/buy" method="post">
<li><input type="submit" value="Buy" /></li>
</form>
</ul>




</body>
</html>