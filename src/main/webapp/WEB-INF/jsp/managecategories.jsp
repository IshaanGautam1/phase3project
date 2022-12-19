<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categories</title>
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
<h2>Manage Categories</h2>
<table>
	<tr>
			<th>Category Id</th>
			<th>Name</th>
			<th>Action</th>
	</tr>
<c:forEach var="category" items = "${categories}">
		<c:url var="deletelink" value ="deletecat" >
			<c:param name="prodcatid" value="${category.prodcatid}"/>
		</c:url>
		<tr>
				<td>${category.prodcatid}</td>
				<td>${category.category}</td>
				<td><a href= "${deletelink}">Delete</a></td>
		</tr>	
	</c:forEach>
</table>
<br><br>
<a href ="manageProducts">Go back</a> | <a href="/logout">logout</a>
</body>
</html>