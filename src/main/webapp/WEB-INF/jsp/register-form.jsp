<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<style type="text/css">
body{
	text-align:center
}
</style>
</head>
<body>
<h2>Registration Form</h2>
<hr>
<br><br>
<form action="processregistration" method="POST">
	Enter a unique username: <input name="username" type="text"/>
	<br>
	Password: <input type="password "name="password"/>
	
	<br>
	<input type="submit" value="Register">
	
</form>
</body>
</html>