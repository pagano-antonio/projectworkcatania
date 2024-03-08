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
<form action="${pageContext.request.contextPath}CandidateRest/addCandidate" method="get">

		
	 	<label for="name">Nome:</label><br>
  		<input type="text" id="name" name="name" ><br><br>
  		<label for="surname" >Cognome:</label><br>
  		<input type="text" id="surname" name="surname"><br><br>
  		<label for="adress">Indirizzo:</label><br>
  		<input type="text" id="adress" name="adress" ><br><br>
  		<label for="city">Città di residenza:</label><br>
  		<input type="text" id="city" name="city" ><br><br>
  		<label for="birthday" >Data di nascita:</label><br>
  		<input type="date" id="birthday" name="birthday" ><br><br>
  		<label for="birthPlace">Città di Nascita:</label><br>
  		<input type="text" id="birthPlace" name="birthPlace" ><br><br>
  		<label for="phone">Numero di telefono:</label><br>
  		<input type="number" id="phone" name="phone"><br><br>
  		<label for="email">Email:</label><br>
  		<input type="number" id="email" name="email"><br><br>
	  	<input type="Submit" value="Invia" style="color:#3f37c9; font-size:20px;">
	  	
	  	</form>
	</div>
	  <br><br>


</body>
</html>