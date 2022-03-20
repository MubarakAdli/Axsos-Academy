<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		
        table,tr,td,th{
            border: 1px solid black;
        }
        table{
            margin-bottom: 20px;
            width: 660px;
        }
        
        
    </style>
</head>
<body>
	<h1><c:out value="${dojo.name}" /> Location Ninjas</h1>
	<table>
		<thead>
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Age</td>
			</tr>
		</thead>
		<tbody>

			<c:forEach var="ninja" items="${ninjas}" >
				<tr>
					<td><c:out value="${ninja.firstName}" /></td>
					<td><c:out value="${ninja.lastName}" /></td>
					<td><c:out value="${ninja.age}" /></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</body>
</html>