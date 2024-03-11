<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="resultBetweenDates" method="post">
        <table>
            <tr>
                <th>Look between period of time</th>
                <td><input type="date" id="starDate" name="startDate" placeholder="Start date"></td>
                <td><input type="date" id="endDate" name="endDate" placeholder="End date"></td>
            </tr>
        </table>
        <input type="submit" value="Submit">
  
    </form>

</body>
</html>