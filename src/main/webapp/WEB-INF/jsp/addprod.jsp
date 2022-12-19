<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="processaddprod" modelAttribute="product">
Product Name: <form:input path="productname"/>
<br>
Image URL: <form:input path="imgurl"/>
<br>
Select Category: 
<select name="prodcat">
<c:forEach items="${categories }" var="category">
		<option value="${category}">${category}</option>	
	</c:forEach>

</select>
<br>
<input type="submit" value="Submit">
</form:form>

</body>
</html>