<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Shoppingcart</h1>

<table border = "1">
		<tr>
		<td><a href="items.jsp">All Items</a></td>
		</tr>
		<form action="<%= request.getContextPath() %>/buy" method="post">
		<li><input type="submit" value="Buy" /></li>
		</form>
</table>

	<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Article Number</th>
		            <th>Name</th>
		            <th>Description</th>
		            <th>Category</th>
		            <th>Count</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${items}" var="items">
					<tr>
						<td>
							 <c:out value="${items.id}" />
						</td>
						<td>
							<c:out value="${items.name}" />
						</td>
						<td>
							<c:out value="${items.description}" />
						</td>
						<td>
							<c:out value="${items.category}" />
						</td>
						<td>
							<c:out value="${items.count}" />
						</td>
					
						
					</tr>
				</c:forEach>
			
			</tbody>
		</table>
	</br>






</body>
</html>