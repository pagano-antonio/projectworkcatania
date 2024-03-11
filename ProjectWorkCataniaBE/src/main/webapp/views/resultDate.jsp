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
            <th>Start Date</th>
            <th>End Date</th>
            <th>Title </th>
            <th>Company Name </th>
            <th>Contract Type </th>
            
                     
</thead>

    <tbody>  	   	
        <c:forEach items="${DateList}" var="listDate">
         
            <tr>
            	<td>${listDate.startDate}</td>
            	<td>${listDate.endDate}</td>
                <td>${listDate.title}</td>
                <td>${listDate.companyClient.name}</td>
                <td>${listDate.contractType.title}</td>
                                                      
               </tr>
                 
        </c:forEach>
  
    </tbody>
</table>



</body>
</html>