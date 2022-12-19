<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report</title>
<style type="text/css">
body{
	text-align:center
}
table{
	margin-left: auto;
  margin-right: auto;
  text-align:center
}
</style>
</head>
<body>
<br><br>
<h4>Select Category and Order</h4>
<form method="POST" action="processreportbycat">
Select Category:
	<select name="prodcat">
<c:forEach items="${categories }" var="category">
		<option value="${category.category}">${category.category}</option>	
	</c:forEach>
</select>
<br>
Select Order with Time: 
<select name="timeorder">
	<option value=1> Ascending</option>
	<option value=2>Descending</option>
</select> 
<br>
<input type="Submit" value="submit">
</form>
</body>
</html>