<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List of results</title>
</head>
<body>

<table>
<thead>
        <tr>  
            <th>Title</th>
            <th>Company Name</th>
            <th>Min Ral</th>
            <th>Max Ral </th>
            
                     
</thead>
    <tbody>  	   	
        <c:forEach items="${RalList}" var="ralList">
         
            <tr>
            	<td>${ralList.title}</td>
            	<td>${ralList.companyClient.name}</td>
                <td>${ralList.minRal}</td>
                <td>${ralList.maxRal}</td>
                                                      
               </tr>
                 
        </c:forEach>  
    </tbody>
</table>


</body>
</html>