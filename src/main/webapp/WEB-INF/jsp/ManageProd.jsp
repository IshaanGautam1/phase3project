<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage products</title>
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
<h3><a href="report">View Report</a> | <a href = "addproduct">Add Product</a> | <a href = "addcategory">Add Category</a> | <a href="managecategories">Manage Categories</a> | <a href="getallusers">View Users</a> | <a href="reportsbycat">View Reports by Category</a> | <a href = "/logout">Logout</a>
<br>
<h1>Manage Products</h1>
<table>
	<tr>
			<th>Product ID</th>
			<th></th>
			<th></th>
			<th>Category</th>
			<th>Action</th>
	</tr>
	<c:forEach var="tempProd" items = "${products }">
		<c:url var="deletelink" value ="delete" >
			<c:param name="prodid" value="${ tempProd.productid}"/>
		</c:url>
		<c:url var="recategorizelink" value ="recategorize" >
			<c:param name="prodid" value="${ tempProd.productid}"/>
		</c:url>
		<tr>
				<td>${tempProd.productid}</td>
				<td><img src="/images/${tempProd.imgurl }"></td>
				<td>${tempProd.productname}</td>
				<td>${tempProd.prodcategory.category}</td>
				<td>
					<a href="${deletelink}">Delete</a> | <a href="${recategorizelink }">Recategorize</a>
				</td>
		</tr>
</c:forEach>	
</table>

</body>
</html>