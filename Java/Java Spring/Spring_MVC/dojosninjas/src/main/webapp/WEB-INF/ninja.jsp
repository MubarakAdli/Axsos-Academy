<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/ninjas/new" method="post" modelAttribute="ninja">
		<p><form:label path="dojo">Dojo: </form:label>
		<form:select path="dojo">
			<c:forEach var="dojo" items="${dojos}" >
				<form:option value="${dojo.id}">
					<c:out value="${dojo.name} " /> 
				</form:option>
			</c:forEach>
		</form:select>
		</p>
		
		
		<form:label path="firstName">First Name: 
		<form:input type="text" path="firstName" />
		<form:errors path="firstName" />
		</form:label>
		<br>
		<form:label path="lastName">Last Name: 
		<form:input type="text" path="lastName" />
		<form:errors path="LastName" />
		</form:label>
		<br>
		<form:label path="age">Age: 
				<form:input type="number" path="age" />
				<form:errors path="age" />
		</form:label>
		<br>
		<br>
		<input type="submit" value="Create">

	</form:form>
</body>
</html>