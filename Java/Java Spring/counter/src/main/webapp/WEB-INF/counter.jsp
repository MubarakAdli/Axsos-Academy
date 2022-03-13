<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>you have visited <a href="/your_server">Http://your_server</a> <c:out value="${countToShow}"/> times</h3>
	<h3> <a href="/your_server">Test another visit!</a></h3>
	<h3><a href="/your_server/delete">Reset Counter</a></h3>
</body>
</html>