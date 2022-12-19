<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
	text-align:center
}
</style>
<meta charset="ISO-8859-1">
<title>Add Category</title>
</head>
<body>
<h3>Add Category</h3>
<br><br>
<form:form action="processaddcategory" modelAttribute="newcategory">
	Enter Category Name<form:input path="category"/>
	<input type="submit" value="ADD">
	</form:form>
	<br><br>
	<hr>
</body>
</html>