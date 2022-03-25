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


.btn{
margin-left: 190px;
margin-top: 10px;
}


</style>
</head>
<body>


<h1>Edit Project</h1>

<form:form action="/projects/${project.id}/edit" method="post" modelAttribute="project">
<input type="hidden" name="_method" value="put">
<div class="form-group">
<label>Project Title</label>
<form:input path="title" class="form-control" />
<form:errors path="title" class="text-danger" />
</div>
<div class="form-group">
<label>Project description</label>
<form:textarea path="description" class="form-control" />
<form:errors path="description" class="text-danger" />
</div>
<div class="form-group">
<label>Due date</label>
<form:input type="date" path="dueDate" class="form-control" />
<form:errors path="dueDate" class="text-danger" />
</div>
<button type="submit" class="btn btn-primary">Submit</button>

</form:form>

</body>
</html>