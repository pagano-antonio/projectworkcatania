<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci candidato</title>
</head>
<body>
 <div align="center">
<form action="${pageContext.request.contextPath}/addCandidate" method="get">

		
	 	<label for="name">Name:</label><br>
  		<input type="text" id="name" name="name" ><br><br>
  		<label for="surname" >Surname:</label><br>
  		<input type="text" id="surname" name="surname"><br><br>
  		<label for="address">Address:</label><br>
  		<input type="text" id="address" name="address" ><br><br>
  		<label for="city">City:</label><br>
  		<input type="text" id="city" name="city" ><br><br>
  		<label for="birthday" >Birth date:</label><br>
  		<input type="date" id="birthday" name="birthday" ><br><br>
  		<label for="birthPlace">City of Birth:</label><br>
  		<input type="text" id="birthPlace" name="birthPlace" ><br><br>
  		<label for="phone">Phone number:</label><br>
  		<input type="number" id="phone" name="phone"><br><br>
  		<label for="email">Email:</label><br>
  		<input type="text" id="email" name="email"><br><br>
	  	<input type="Submit" value="Invia" style="color:#3f37c9; font-size:20px;">
	  	
	  	</form>
	</div>
	  <br><br>


</body>
</html>