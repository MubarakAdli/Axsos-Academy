<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div style="display: flex;justify-content: space-between;">
	<a href="/songs/new">Add New</a>
	<a href="/topTen">Top Songs</a>
	<form:form action="/search" method="post">
	<input type="search" name="search">
	<button type="submit">New Search</button>
	</form:form>  
	</div>
	<table class="table" style="width : 500px;">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Rating</th>
      <th scope="col">Actions</th>
    
    </tr>
  </thead>
  <tbody>
  <c:forEach var="song" items="${songs}">
    <tr>
 
      <td><a href="/songs/${song.id}"><c:out value="${song.title}"></c:out></a></td>
      <td><c:out value="${song.rate}"></c:out></td>
      <td><a href="songs/${song.id}/delete">delete</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>