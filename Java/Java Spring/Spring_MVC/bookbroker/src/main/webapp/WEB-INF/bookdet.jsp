<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<style>
.top{display: flex;
align-items: center;
}
.anc{
margin-left: 100px;}
</style>
</head>
<body>

<div class="top">
<h1><c:out value="${book.title}"></c:out></h1>
<h3><a href="/books" class="anc">back to the shelves</a></h3>
</div>

  <p>${book.user.userName} read ${book.title} by ${book.author}.<br>
  Here are ${book.user.userName}  </p>
  <p >${book.thoughts}</p>
</body>
</html>