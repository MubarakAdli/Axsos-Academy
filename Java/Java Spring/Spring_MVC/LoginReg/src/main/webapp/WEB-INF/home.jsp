<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Welcome</title>
	
	<style>
	h1{color: #a113ff;
}
	</style>
</head>
<body>
	<h1>Welcome, <c:out value="${user.userName}" /></h1>
	<h3>This is dashboard nothing to see here yet </h3>
	<a href="/logout">Logout</a>
</body>
</html>