<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <form action="pageResultRal" method="post">
        <table>
            <tr>
                <th>Search between annual incomes</th>
               
                 <td><input type="number" id="minRal" name="minRal" placeholder="insert minimum income"></td>
                 <td><input type="number" id="maxRal" name="maxRal" placeholder="insert maximum income"></td>
            </tr>
        </table>
        <input type="submit" value="Submit">
  
    </form>

</body>
</html>