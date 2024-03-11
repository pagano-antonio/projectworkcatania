<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Company Client</title>
</head>
<body>
	<div class="container">
		<h2>Add New Company Client</h2>
		<form action="${pageContext.request.contextPath}/preAddCompanyClient" method="post"><br> 
		<label for="name">Name</label><br> 
		   <input type="text" id="name" name="name" value=""><br>
		<label for="city">City</label><br> 
		   <input type="text" id="city" name="city" value=""><br> 
				<input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>