<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate List By Education</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<style>

html,
body {
	height: 100%;
}

body {
	margin: 0;
	background: linear-gradient(45deg, #49a09d, #5f2c82);
	font-family: sans-serif;
	font-weight: 100;
}

.container {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

table {
	width: 1100px;
	border-collapse: collapse;
	overflow: hidden;
	box-shadow: 0 0 20px rgba(0,0,0,0.1);
	font-family: Lato, sans-serif;
}

th{
	padding: 15px;
	background-color: rgba(255,255,255,0.2);
	color: white;
	text-align: left;

}

td {
	padding: 15px;
	background-color: rgba(255,255,255,0.2);
	color: #4542f5;
}

thead {
	th {
		background-color: #55608f;
	}
}

tbody {
	tr {
		&:hover {
			background-color: rgba(255,255,255,0.3);
		}
	}
	td {
		position: relative;
		&:hover {
			&:before {
				content: "";
				position: absolute;
				left: 0;
				right: 0;
				top: -9999px;
				bottom: -9999px;
				background-color: rgba(255,255,255,0.2);
				z-index: -1;
			}
		}
	}
}

/*Separatore due stili*/

*{
  margin: 0;
  padding: 0;
  text-decoration: none;
}
:root {
  --accent-color: #fff;
  --gradient-color: #FBFBFB;
}
body{
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
   width: 100vw;
  height: 100vh;
  background-image: linear-gradient(-45deg, #e3eefe 0%, #efddfb 100%);
}

.sidebar{
  position: fixed;
  width: 240px;
  left: -240px;
  height: 100%;
  background-color: #fff;
  transition: all .5s ease;
}
.sidebar header{
  font-size: 28px;
  color: #353535;
  line-height: 70px;
  text-align: center;
  background-color: #fff;
  user-select: none;
  font-family: 'Lato', sans-serif;
}
.sidebar a{
  display: block;
  height: 65px;
  width: 100%;
  color: #353535;
  line-height: 65px;
  padding-left: 30px;
  box-sizing: border-box;
  border-left: 5px solid transparent;
  font-family: 'Lato', sans-serif;
  transition: all .5s ease;
}
a.active,a:hover{
  border-left: 5px solid var(--accent-color);
  color: #fff;
   background: linear-gradient(to left, var(--accent-color), var(--gradient-color));
}
.sidebar a i{
  font-size: 23px;
  margin-right: 16px;
}
.sidebar a span{
  letter-spacing: 1px;
  text-transform: uppercase;
}
#check{
  display: none;
}
label #btn,label #cancel{
  position: absolute;
  left: 10px; /* sposta il pulsante a sinistra di 10px */
  top: 15px; /* sposta il pulsante verso l'alto di 15px */
  cursor: pointer;
  color: #d6adff;
  border-radius: 5px;
  margin: 15px 30px;
  font-size: 29px;
  background-color: #e8d1ff;
  box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
    inset -7px -7px 10px 0px rgba(0,0,0,.1),
   3.5px 3.5px 20px 0px rgba(0,0,0,.1),
   2px 2px 5px 0px rgba(0,0,0,.1);
  height: 45px;
  width: 45px;
  text-align: center;
  text-shadow: 2px 2px 3px rgba(255,255,255,0.5);
  line-height: 45px;
  transition: all .5s ease;
}
label #cancel{
  opacity: 0;
  visibility: hidden;
}
#check:checked ~ .sidebar{
  left: 0;
}
#check:checked ~ label #btn{
  margin-left: 245px;
  opacity: 0;
  visibility: hidden;
}
#check:checked ~ label #cancel{
  margin-left: 245px;
  opacity: 1;
  visibility: visible;
}
@media(max-width : 860px){
  .sidebar{
    height: auto;
    width: 70px;
    left: 0;
    margin: 100px 0;
  }
  header,#btn,#cancel{
    display: none;
  }
  span{
    position: absolute;
    margin-left: 23px;
    opacity: 0;
    visibility: hidden;
  }
  .sidebar a{
    height: 60px;
  }
  .sidebar a i{
    margin-left: -10px;
  }
  a:hover {
    width: 200px;
    background: inherit;
  }
  .sidebar a:hover span{
    opacity: 1;
    visibility: visible;
  }
}

.sidebar > a.active,.sidebar > a:hover:nth-child(even) {
  --accent-color: #52d6f4;
  --gradient-color: #c1b1f7;
}
.sidebar a.active,.sidebar > a:hover:nth-child(odd) {
  --accent-color: #c1b1f7;
  --gradient-color: #A890FE;
}


.frame {
  width: 50%;
  height: 30%;
  margin: auto;
  text-align: center;
}

h2 {
  position: relative;
  text-align: center;
  color: #353535;
  font-size: 60px;
  font-family: 'Lato', sans-serif;
  margin: 0;
  color: #a759f5;
}

p {
  font-family: 'Lato', sans-serif;
  font-weight: 300;
  text-align: center;
  font-size: 30px;
  color: #d6adff;
  margin: 0;
}

/*stile bottoni*/
/*html bottoni: <button class="button-48" role="button"><span class="text">Update</span></button> */
.button-48 {
  appearance: none;
  background-color: #FFFFFF;
  border-width: 0;
  box-sizing: border-box;
  color: #000000;
  cursor: pointer;
  display: inline-block;
  font-family: Lato, sans-serif;
  font-size: 14px;
  font-weight: 500;
  letter-spacing: 0;
  line-height: 1em;
  margin: 0;
  opacity: 1;
  outline: 0;
  padding: 0.4em 0.9em; /*dimensioni bottoni*/
  position: relative;
  text-align: center;
  text-decoration: none;
  text-rendering: geometricprecision;
  text-transform: uppercase;
  transition: opacity 300ms cubic-bezier(.694, 0, 0.335, 1),background-color 100ms cubic-bezier(.694, 0, 0.335, 1),color 100ms cubic-bezier(.694, 0, 0.335, 1);
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
  vertical-align: baseline;
  white-space: nowrap;
  border-radius: 10px;
  box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16); /*ombreggiatura sotto bottone*/
  
}

.button-48:before {
  animation: opacityFallbackOut .5s step-end forwards;
  backface-visibility: hidden;
  background-color: #caf0f8; /* Nuovo colore di sfondo su hover */
  clip-path: polygon(-1% 0, 0 0, -25% 100%, -1% 100%);
  content: "";
  height: 100%;
  left: 0;
  position: absolute;
  top: 0;
  transform: translateZ(0);
  transition: clip-path .5s cubic-bezier(.165, 0.84, 0.44, 1), -webkit-clip-path .5s cubic-bezier(.165, 0.84, 0.44, 1);
  width: 100%;
  border-radius: 10px;
}

.button-48:hover:before {
  animation: opacityFallbackIn 0s step-start forwards;
  clip-path: polygon(0 0, 101% 0, 101% 101%, 0 101%);
}

.button-48:after {
  background-color: #FFFFFF;
}

.button-48 span {
  z-index: 1;
  position: relative;
}

</style>
</head>

<body>
    <input type="checkbox" id="check">
    <label for="check">
      <i class="fas fa-bars" id="btn"></i>
      <i class="fas fa-times" id="cancel"></i>
    </label>
    <div class="sidebar">
      <header>Menu</header>
      <a href="${pageContext.request.contextPath}/home" class="active">
        <i class="fas fa-qrcode"></i>
        <span>Home</span>
      </a>
      <a href="${pageContext.request.contextPath}/preSearchCandidateByEducation"target="_blank">
        <i class="fas fa-school"></i>
        <span>Back to Search</span>
      </a>
   	 	<a href="${pageContext.request.contextPath}/preSearchCandidateByCity"target="_blank">
         <i class="fas fa-building"></i>
        <span>By City</span>
      	</a>
       <a href="${pageContext.request.contextPath}/preSearchCandidateBySurname"target="_blank">
         <i class="fas fa-calendar-check"></i>
        <span>By Surname</span>
      </a>
       <a href="${pageContext.request.contextPath}/preSearchCandidateByPhone"target="_blank">
         <i class="fas fa-phone"></i>
        <span>By Phone</span>
      </a>
        <a href="${pageContext.request.contextPath}/preSearchCandidateBySkill"target="_blank">
         <i class="fas fa-clipboard"></i>
        <span>By Skill</span>
      </a>
       <a href="${pageContext.request.contextPath}/preSearchCandidateByWorkExp"target="_blank">
         <i class="fas fa-briefcase"></i>
        <span>By Experience</span>
      </a>
    </div>
</body>


<div class="container">


<table>
<thead>

<tr>
<th>Name</th>
<th>Surname</th>
<th>Birth Date</th>
<th>Birth Place</th>
<th>Address</th>
<th>City</th>
<th>Email</th>
<th>Phone Number</th>
<th colspan="3">Buttons</th>

</tr>
</thead>
<tbody>

<c:forEach var="candidate" items="${candidateEducationFound}">
<tr>

<td>${candidate.name}</td>
<td>${candidate.surname}</td>
<td>${candidate.birthday}</td>
<td>${candidate.birthPlace}</td>
<td>${candidate.address}</td>
<td>${candidate.city}</td>
<td>${candidate.email}</td>
<td>${candidate.phone}</td>

<td>

	   	<form action="${pageContext.request.contextPath}/preUpdateCandidate" method="post">
    	<input type="hidden" name="idCandidate" value="${candidate.idCandidate}">
    	<button class="button-48" role="button"><span class="text">Update</span></button>
		</form><br>


	   	<form action="${pageContext.request.contextPath}CandidateSkillController/candidateSkills" method="post">
   		<input type="hidden" name="idCandidate" value="${candidate.idCandidate}">
    	<button class="button-48" role="button"><span class="text">Skill</span></button>
		</form><br>
		

	   	<form action="${pageContext.request.contextPath}EducationController/searchByIdCandidate" method="post">
   		<input type="hidden" name="idCandidate" value="${candidate.idCandidate}">
    	<button class="button-48" role="button"><span class="text">Education</span></button>
		</form><br>
		
<td>
	   	<form action="${pageContext.request.contextPath}WorkExperienceController/searchByIdCandidate" method="post">
   		<input type="hidden" name="idCandidate" value="${candidate.idCandidate}">
    	<button class="button-48" role="button"><span class="text">Experiences</span></button>
		</form><br>
		

	   	<form action="${pageContext.request.contextPath}CandidateCommercialDataController/searchCommercialDataByIdCandidate" method="post">
   		<input type="hidden" name="idCandidate" value="${candidate.idCandidate}">
    	<button class="button-48" role="button"><span class="text">Commercial Data</span></button>
		</form><br>
		
</td>

</tr>
</c:forEach>
</tbody>
</table>
</div>
</body>
</html>