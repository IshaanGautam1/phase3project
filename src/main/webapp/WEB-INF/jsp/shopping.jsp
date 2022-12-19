<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes Shop</title>
</head>
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
<body>
<h2>Sporty Shoes!</h2>
<br>
<a href= "/logout">Logout</a>
<br><br>
<table>
<tr>
		<th>Product Name</th>
		<th>Image</th>
		<th>Category</th>
		<th>Link</th>
</tr>
<c:forEach var="tempProd" items = "${products }">
		<c:url var="buylink" value ="buyproduct" >
			<c:param name="prodid" value="${ tempProd.productid}"/>
		</c:url>
		<tr>
				<td>${tempProd.productname}</td>
				<td><img src="/images/${tempProd.imgurl }"></td>
				<td>${tempProd.prodcategory.category}</td>
				<td>
					<a href="${buylink }">Buy</a>
				</td>
		</tr>
</c:forEach>	

</table>
</body>
</html>