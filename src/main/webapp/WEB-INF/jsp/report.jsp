<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders Report</title>
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
	<h1>Orders Report</h1>
	<br><br>
<table>
		<tr>
				<th>Order ID</th>
				<th>User</th>
				<th>Time</th>
				<th>Product</th>
				<th>Category</th>
		</tr>
		<c:forEach var = "temporder" items = "${orders }">
			<tr>
					<td>${temporder.id }</td>
					<td>${temporder.user.username }</td>
					<td>${temporder.time }</td>
					<td>${temporder.product.productname}</td>
					<td>${temporder.product.prodcategory.category }</td>
			</tr>
		</c:forEach>
</table>
<br><br>
<a href="manageProducts">Go Back</a>
</body>
</html>