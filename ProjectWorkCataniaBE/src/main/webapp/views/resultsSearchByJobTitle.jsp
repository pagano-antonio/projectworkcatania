<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<style>
      body {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
    }

    table {
        width: 50%;
        border-collapse: collapse;
        border-radius: 10px;
        overflow: hidden;
    }
    th, td {
        padding: 8px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #B1E591;
        color: green;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
        
    }
    tr:hover {
        background-color: #82D386;
    }
</style>
   
<table>
<thead>
        <tr>  
            <th>Title</th>
            <th>Description</th>
            <th>Company Name </th>
            <th>Contract Type </th>
                     
</thead>

    <tbody>  	   	
        <c:forEach items="${JobOfferByTitle}" var="listJobs">
         
            <tr>
                <td>${listJobs.title}</td>
                <td>${listJobs.description}</td>
                <td>${listJobs.companyClient.name}</td>
                <td>${listJobs.contractType.title}</td>
                                                      
               </tr>
                 
        </c:forEach>
  
    </tbody>
</table>



</body>
</html>