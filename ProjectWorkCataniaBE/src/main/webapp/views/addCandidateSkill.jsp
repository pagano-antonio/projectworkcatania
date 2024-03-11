<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Candidate Skill</title>
</head>
<body>
 <div align="center">
<form action="${pageContext.request.contextPath}/CandidateSkillController/addCandidateSkill" method="get">

		
	 	<label for="candidate.idCandidate">Id Candidate:</label><br>
  		<input type="number" id="candidate.idCandidate" name="candidate.idCandidate" ><br><br>
  		<label for="skill.idSkill" >Id Skill:</label><br>
  		<input type="number" id="skill.idSkill" name="skill.idSkill"><br><br>
	  	<input type="Submit" value="Invia" style="color:#3f37c9; font-size:20px;">
	  	
	  	</form>
	</div>
	  <br><br>



</body>
</html>