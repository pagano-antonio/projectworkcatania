<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>La Tua Home</title>
</head>
<body>


<br>
<div align="center">
La Tua Home Page

<a href="${pageContext.request.contextPath}/preAddCandidate"target="_blank">
<button type="button">Add Candidate</button></a>
<br>
<a href="${pageContext.request.contextPath}/CandidateSkillController/preAddCandidateSkill"target="_blank">
<button type="button">Add Candidate Skill</button></a>

<a href="${pageContext.request.contextPath}/pageSearchByTitle" class="button"> search job title from title</a>
<a href="${pageContext.request.contextPath}/pageSearchRal" class="button"> search between annual incomes</a>

</div>

</body>
</html>