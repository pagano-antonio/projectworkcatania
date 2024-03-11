<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addCandidate" method="get">

		<c:set var="candidate" value="${CandidateFound}"/>
	 	
		<label for="idCandidate">ID Candidate:</label> <br> 
		<input readonly="readonly" id="idCandidate" name="idCandidate" value="${candidate.idCandidate}"><br>
	 	<label for="name">Nome:</label><br>
  		<input type="text" id="name" name="name" value="${candidate.name}" ><br><br>
  		<label for="surname" >Cognome:</label><br>
  		<input type="text" id="surname" name="surname" value="${candidate.surname}"><br><br>
  		<label for="address">Indirizzo:</label><br>
  		<input type="text" id="address" name="address" value="${candidate.address}"><br><br>
  		<label for="city">Città di residenza:</label><br>
  		<input type="text" id="city" name="city" value="${candidate.city}"><br><br>
  		<label for="birthday" >Data di nascita:</label><br>
  		<input type="date" id="birthday" name="birthday" value="${candidate.birthday}"><br><br>
  		<label for="birthPlace">Città di Nascita:</label><br>
  		<input type="text" id="birthPlace" name="birthPlace" value="${candidate.birthPlace}"><br><br>
  		<label for="phone">Numero di telefono:</label><br>
  		<input type="number" id="phone" name="phone" value="${candidate.phone}"><br><br>
  		<label for="email">Email:</label><br>
  		<input type="text" id="email" name="email" value="${candidate.email}"><br><br>
	  	<input type="Submit" value="Invia" style="color:#3f37c9; font-size:20px;">
	  	
	  	</form>

</body>
</html>