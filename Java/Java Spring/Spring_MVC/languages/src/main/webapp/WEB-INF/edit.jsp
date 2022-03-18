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
	.but{border: none;
    background-color: white;
    text-decoration: underline;
    color: blue;
    margin-left: -34px;
}

.row{
display: flex;
justify-content: center;
}
.label{
margin-left: 220px;

}

.sub{
margin-left: 400px;
background-color: white;
}
</style>
</head>
<body>

	<div class="row">
				<a href="/languages">Dashboard</a>|
					<form action="/languages/${language.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input class="but" type="submit" value="Delete">
						</form>
					</div>
	
	<form:form action="/languages/edit/${language.id}" method="put"
		modelAttribute="language">
		<input type="hidden" name="_method" value="put">
		<p>
			<form:label  path="name">Name</form:label>
			<form:errors path="name" />
			<form:input class="label" path="name" />
		</p>
		<p>
			<form:label  path="creator">Creator</form:label>
			<form:errors path="creator" />
			<form:input class="label" path="creator" />
		</p>

		<p>
			<form:label path="version">Version</form:label>
			<form:errors path="version" />
			<form:input class="label" path="version" />
		</p>
		<input class="sub" type="submit" value="Submit" />
	</form:form>

</body>
</html>