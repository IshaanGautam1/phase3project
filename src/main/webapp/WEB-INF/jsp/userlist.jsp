<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
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
<h2>Users</h2>
<hr><br>
<form action="getuserbyname" method="POST">
	Username : <input type="text"  name="username"> 
	<input type = "submit" value="search">
	</form>
	<br><hr><br>
	<table>
		<tr>
				<th>User ID</th>
				<th>Username</th>
		</tr>
			<c:forEach var = "tempuser"  items = "${users }">
				<tr>	
						<td>${tempuser.id}</td>
						<td>${tempuser.username }</td>
				</tr>
			</c:forEach>
	</table>
	<br><br>
	<a href="manageProducts">Go Back</a>
</body>
</html>