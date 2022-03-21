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

<title>Products</title>
</head>
<body>
<h1><c:out value="${product.name}"></c:out></h1>
	<p> Categories:
	<ul >
	 <c:forEach var="category" items="${categoryContains}">
		  <li><c:out value="${category.name}"></c:out></li>
		  </c:forEach>
		</ul> 
	 </p>
	<form action="/new/category/${product.id }" method="post" >
	<div >
	<div >
  <div class="row">
  <label >categories </label>
    <select name="categories" > 
     <c:forEach var="category" items="${categoryNotContains}">
     <option value="${category.id }">${category.name}</option>
     </c:forEach>
     </select>
  </div>
</div>
</div>
 <button type="submit" >Submit</button>
</form>
</body>
</html>