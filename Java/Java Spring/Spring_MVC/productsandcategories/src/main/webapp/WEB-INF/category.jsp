<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>insert a title</title>
</head>
<body class="container">
<h1><c:out value="${category.name}"></c:out></h1>
	<p> Products:
	<ul>
	 <c:forEach var="product" items="${productContains}">
		  <li><c:out value="${product.name}"></c:out></li>
		  </c:forEach>
		</ul> 
	 </p>
	<form action="/new/product/${category.id }" method="post" >
	<div>
	<div>
  <div >
  <label >products </label>
    <select name="products"> 
     <c:forEach var="product" items="${productNotContains}">
     <option value="${product.id }">${product.name}</option>
     </c:forEach>
     </select>
  </div>
</div>
</div>
 <button type="submit" >Submit</button>
</form>
</body>
</html>