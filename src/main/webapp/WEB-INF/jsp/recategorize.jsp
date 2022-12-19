<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recategorize</title>
<style type="text/css">
	body{
	text-align:center;
	}
	</style>
</head>
<body>
<h1>Recategorize</h1>
<br><br>
<form action="processrecategorize" method="POST">
Select Category: 
<select name="prodcat">
<c:forEach items="${categories }" var="category">
		<option value="${category.category}">${category.category}</option>	
	</c:forEach>
</select>
<input type="hidden" value=${productid } name="productid">
<br>
<input type="Submit" value="Submit">
</form>
<br>

</body>
</html>