<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="pageResultAddTitle" method="post">
        <table>
            <tr>
                <th>Add Job Title</th>
                <td><input type="text" id="title" name="title"></td>
            </tr>
            <tr>
                <th>Add Job Description</th>
                <td><input type="text" id="description" name="description"></td>
            </tr>
            <tr>
                <th>Add Start date</th>
                <td><input type="date" id="startDate" name="startDate"></td>
            </tr>
            <tr>
                <th>Add End date</th>
                <td><input type="date" id="endDate" name="endDate"></td>
            </tr>
            <tr>
                <th>Add minimum wage</th>
                <td><input type="number" id="minRal" name="minRal"></td>
            </tr>
            <tr>
                <th>Add maximum wage</th>
                <td><input type="number" id="maxRal" name="maxRal"></td>
            </tr>
            
        </table>
        <input type="submit" value="Submit">
  
    </form>


</body>
</html>