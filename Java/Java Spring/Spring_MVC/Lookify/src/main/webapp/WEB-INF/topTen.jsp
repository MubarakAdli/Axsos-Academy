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
<a href="/dashboard" style="margin-left: 20px;">Dashboard</a>
<h1 style="margin-left: 20px;">Top Ten songs</h1>
<div style="margin-left: 20px;outline: 2px solid black;width: 350px;padding-left: 10px;">
 <c:forEach var="song" items="${songs}">
 <p>${song.rate} - ${song.title} - ${song.artist}</p>
  </c:forEach>
  </div>
 
</body>
</html>