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
	
	
<h1>Add a book to your shelf</h1>
<a href="/books">Back</a>
	<form:form action="/books/new" method="post" modelAttribute="book">
		<input type="hidden" name="_method" value="post">
		<p>
			<form:label path="title">Name</form:label>
			<form:errors path="title" />
			<form:input path="title" />
		</p>
		<p>
			<form:label path="author">Title</form:label>
			<form:errors path="author" />
			<form:input path="author" />
		</p>

		<p>
			<form:label path="thoughts">My thoughts</form:label>
			<form:errors path="thoughts" />
			<form:input path="thoughts" />
		</p>
		<input class="sub" type="submit" value="Submit" />
	</form:form>
	

</body>
</html>