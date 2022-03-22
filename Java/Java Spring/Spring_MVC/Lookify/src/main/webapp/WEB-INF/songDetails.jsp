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
<a href="/dashboard" style="margin-left: 100px;margin-top: 20px;">Dashboard</a>
<div style="margin-left: 100px;margin-top: 100px">
<div style="display: flex;width: 300px;justify-content: space-between;">
	<p >Title</p>
	<p>${song.title}</p>
</div>
<div style="display: flex;width: 300px;justify-content: space-between;">
	<p >Artist</p>
	<p>${song.artist}</p>
</div>
<div style="display: flex;width: 300px;justify-content: space-between;">
	<p >Rating (1-10)</p>
	<p>${song.rate}</p>
</div>
</div>
</body>
</html>