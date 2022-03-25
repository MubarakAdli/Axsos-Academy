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
        
        .but{
    border: none;
    background-color: white;
    text-decoration: underline;
}
	</style>
</head>
<body>
	<div class="top">
	<div>
	<h3>Hello, <c:out value="${loggedInUser.userName}" />. Welcome to  </h3>
	<h1>The Book Broker!</h1>
	</div>
	<div class=top-1>
	<h3><a href="/logout">Logout</a></h3>
	<h3><a href="/books/new">+ add to my shelve</a></h3>
	</div>
	</div>
	<h3>Available Books to Borrow</h3>
	<table>
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Owner</th>
			<th>Actions</th>
		</tr>
		<c:forEach var="book" items="${availableBooks}">
			<tr>
				<td><c:out value="${book.id}"></c:out></td>
				 <td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
				<td><c:out value="${book.author}"></c:out></td>
				<td><c:out value="${book.user.userName}"></c:out></td>
				<td>
				<c:choose>
				<c:when test="${loggedInUser.id !=book.user.id}">
				<form action="/borrow/${book.id}" method="post">
						    <input type="hidden" name="_method" value="Put">
						    <input class="but" type="submit" value="borrow">
						</form>
				</c:when>
				<c:otherwise>
				<a href="/books/${book.id}/edit">edit</a>
				</c:otherwise>
				</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<h3>Books I'm borrowing</h3>
	<table>
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Author Name</th>
			<th>Owner</th>
			<th>Actions</th>

		</tr>
		<c:forEach var="book" items="${borrowedBooks}">
			<tr>
				<td><c:out value="${book.id}"></c:out></td>
				 <td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
				<td><c:out value="${book.author}"></c:out></td>
				<td><c:out value="${book.user.userName}"></c:out></td>
				
    			
				<td>
				<c:choose>
				<c:when test="${loggedInUser.id ==book.user.id}">
				<a href="#">return</a>
				</c:when>
				<c:otherwise>
				<form action="/return/${book.id}" method="post">
						    <input type="hidden" name="_method" value="Put">
						    <input class="but" type="submit" value="return">
						</form>
				</c:otherwise>
				</c:choose>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>