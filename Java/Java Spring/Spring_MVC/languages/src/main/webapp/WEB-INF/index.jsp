<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Languages</title>
<style>

table,tr,td,th{
            border: 1px solid black;
            text-align: center;
        }

        table{
            margin-bottom: 20px;
            width: 660px;
        }
.but{border: none;
    background-color: white;
    text-decoration: underline;
    color: blue;
}

.row{
display: flex;
}

.sub{
margin-left: 150px;
background-color: white;
}

</style>
</head>
<body>
	
	<table>
		<tr>
			<th>Name</th>
			<th>Creator</th>
			<th>Version</th>
			<th>Actions</th>

		</tr>
		<c:forEach var="language" items="${languages}">
			<tr>
				<td><a href="/languages/${language.id}"><c:out
							value="${language.name}"></c:out></a></td>
				<td><c:out value="${language.creator}"></c:out></td>
				<td><c:out value="${language.version}"></c:out></td>
				<td><div class="row">
				<a href="/languages/edit/${language.id}">Edit</a>|
					<form action="/languages/${language.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input class="but" type="submit" value="Delete">
						</form></td>
					</div>

			</tr>
		</c:forEach>
	</table>

	<form:form action="/languages" method="post" modelAttribute="language">
		<input type="hidden" name="_method" value="post">
		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name" />
			<form:input path="name" />
		</p>
		<p>
			<form:label path="creator">Creator</form:label>
			<form:errors path="creator" />
			<form:input path="creator" />
		</p>

		<p>
			<form:label path="version">Version</form:label>
			<form:errors path="version" />
			<form:input path="version" />
		</p>
		<input class="sub" type="submit" value="Submit" />
	</form:form>

</body>
</html>