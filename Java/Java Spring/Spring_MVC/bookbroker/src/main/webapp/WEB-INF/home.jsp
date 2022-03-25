<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Welcome</title>
	
	<style>
	.top{display: flex;
	
	}
	.top-1{margin-left: 200px;
	
	}
	
	table,tr,td,th{
            border: 1px solid black;
            text-align: center;
        }
        table{
            margin-bottom: 20px;
            width: 660px;
        }
	</style>
</head>
<body>
	<div class="top">
	<div>
	<h1>Welcome, <c:out value="${loggedInUser.userName}" /></h1>
	<h3>Books from everyone's shelves </h3>
	</div>
	<div class=top-1>
	<h3><a href="/logout">Logout</a></h3>
	<h3><a href="/books/new">+ add to my shelve</a></h3>
	</div>
	</div>
	
	<table>
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Posted by</th>

		</tr>
		<c:forEach var="book" items="${books}">
			<tr>
				<td><c:out value="${book.id}"></c:out></td>
				 <td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
				<td><c:out value="${book.author}"></c:out></td>
				<td><c:out value="${book.user.userName}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	<h2><a href="/bookmarket">Bookmarket</a></h2>
</body>
</html>