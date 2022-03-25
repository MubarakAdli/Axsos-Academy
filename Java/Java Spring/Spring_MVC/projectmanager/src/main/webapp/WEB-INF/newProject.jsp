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

.new-project {
    border: 2px solid black;
    color: black;
    text-decoration: none;
    font-size: 20px;
    margin-left: 30px;
}


</style>
</head>
<body>
	
	
	<h2>Create New Project</h2>
	<form:form action="/projects/new" method="post" modelAttribute="project">
		<input type="hidden" name="_method" value="post">
		<p>
			<form:label path="title">Project Title</form:label>
			<form:errors path="title" />
			<form:input path="title" />
		</p>
		<p>
			<form:label path="description">Project Description</form:label>
			<form:errors path="description" />
			<form:input path="description" />
		</p>

		<p>
			<form:label path="dueDate">Due date</form:label>
			<form:errors path="dueDate" />
			<form:input type="date" path="dueDate" />
		</p>
		
		<input class="sub" type="submit" value="Submit" />
		<h3 ><a class="new-project" href="/dashboard">cancel</a></h3>
		
	</form:form>

</body>
</html>