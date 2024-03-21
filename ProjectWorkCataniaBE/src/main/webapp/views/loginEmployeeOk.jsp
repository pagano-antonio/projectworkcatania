<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Account</title>
<link rel="stylesheet" type="text/css" href="styles.css">
<link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
<link href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" rel="stylesheet">
<style>

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


/*Animated text h2*/
.title-word {
    animation: color-animation 4s linear infinite;
    
  }
  
   .title-word-5 {
   	--color-1: #a759f5;
    --color-2: #219ebc;
    --color-3: #E4A9A8;
  }
  
  @keyframes color-animation {
    0%    {color: var(--color-1)}
    32%   {color: var(--color-1)}
    33%   {color: var(--color-2)}
    65%   {color: var(--color-2)}
    66%   {color: var(--color-3)}
    99%   {color: var(--color-3)}
    100%  {color: var(--color-1)}
  }
 
</style>
</head>


<body>
<c:forEach var="employee" items="${employeeFound}">
    <input type="checkbox" id="check">
    <label for="check">
      <i class="fas fa-bars" id="btn"></i>
      <i class="fas fa-times" id="cancel"></i>
    </label>
    <div class="sidebar">
      <header>Menu</header>
      <a href="${pageContext.request.contextPath}/home" class="active">
        <i class="fas fa-qrcode"></i>
        <span>Log Out</span>
      </a>
      <a href="${pageContext.request.contextPath}/preUpdateEmployee?idEmployee=${employee.idEmployee}"target="_blank">
        <i class="fas fa-user"></i>
        <span>Update Account</span>
      </a>
       <a href="${pageContext.request.contextPath}JobInterviewController/preAddJobInterview"target="_blank">
         <i class="fas fa-clipboard"></i>
        <span>Add Interview</span>
      </a>
      <a href="${pageContext.request.contextPath}SkillController/preAddSkill"target="_blank">
         <i class="fas fa-briefcase"></i>
        <span>Add Skill</span>
      </a>
      <a href="${pageContext.request.contextPath}SkillController/preSearchSkillByTitle"target="_blank">
         <i class="fas fa-briefcase"></i>
        <span>Search Skill</span>
      </a>
       <a href="${pageContext.request.contextPath}/JobInterviewController/searchByIdEmployee?idEmployee=${employee.idEmployee}" target="_blank">
        <i class="fas fa-calendar"></i>
        <span>Your Interviews</span>
      </a>
      <a href="${pageContext.request.contextPath}deleteEmployee?idEmployee=${employee.idEmployee}" target="_blank">
        <i class="fas fa-trash"></i>
        <span>Delete Account</span>
      </a>
    </div>
    </c:forEach>
</body>

<c:forEach var="employee" items="${employeeFound}">
 <div class="frame">
<p>Welcome</p>
<h2 class="title-word title-word-5">${employee.name}<br>${employee.surname}<br></h2> <%--scritta colorata --%>
  <p>in your Page</p>
</div>
</c:forEach>


</body>
</html>