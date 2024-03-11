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

<table>
<thead>
        <tr>  
            <th>title</th>
            <th>Company name</th>
            <th>min ral</th>
            <th>max rax </th>
            
                     
</thead>
    <tbody>  	   	
        <c:forEach items="${toby}" var="s">
         
            <tr>
            	<td>${s.title}</td>
            	<td>${s.companyClient.name}</td>
                <td>${s.minRal}</td>
                <td>${s.maxRal}</td>
                                                      
               </tr>
                 
        </c:forEach>  
    </tbody>
</table>


</body>
</html>