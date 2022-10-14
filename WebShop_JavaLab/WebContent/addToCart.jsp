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
<h1>HEJ</h1>
 Out of ${itemToCart.count} how many ${itemToCart.name} do you wanna put in the cart?


 <form action="addToCart" method="post" >
 	<fieldset class="form-group">
     <label>Quantity</label> <input type="text" name="amount"/>
      <input type="hidden" name="id" value='${itemToCart.id}'/>
      <input type="hidden" name="count" value='${itemToCart.count}'/>
 	<button type="submit"> Add To Cart</button>
 </fieldset>
 </form>
 
 
</body>
</html>