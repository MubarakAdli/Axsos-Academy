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
<a href="/dashboard">Dashboard</a>

<form:form action="/songs/new" method="post" modelAttribute="songs" style="width:400px;">
    <p style="display:flex; justify-content:space-between;">
        <form:label path="title">Title</form:label>
        <form:input type="text" path="title"/>
        <form:errors path="title"/>
    </p>
    <p style="display:flex; justify-content:space-between;">
        <form:label path="artist">Artist</form:label>
        <form:errors path="artist"/>
        <form:input type="text" path="artist"/>
    </p>
    <p style="display:flex; justify-content:space-between;">
        <form:label path="rate">Rating (1-10)</form:label>
        <form:errors path="rate"/>
        <form:input type="number" path="rate"/>
    </p>    
    <button type="submit">Add Song</button>
	</form:form>  
</body>
</html>