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
h1{color: #a113ff;
}

.btn{
margin-left: 190px;
margin-top: 10px;
}
 .delbut {background: red;
    color: white;
	
}
.form-group{
display: flex;

margin-top: 10px;
}

input{margin-left: 10px;
}

</style>
</head>
<body>

<div>
<h1>Change your Entry</h1>

<form:form action="/books/${book.id}/edit" method="post" modelAttribute="book">
<input type="hidden" name="_method" value="put">
<div class="form-group">
<label>Title:</label>
<form:input path="title" class="form-control" />
<form:errors path="title" class="text-danger" />
</div>
<div class="form-group">
<label>Author:</label>
<form:input path="author" class="form-control" />
<form:errors path="author" class="text-danger" />
</div>
<div class="form-group">
<label>My thoughts:</label>
<form:input path="thoughts" class="form-control" />
<form:errors path="thoughts" class="text-danger" />
</div>

<button type="submit" class="btn btn-primary">Submit</button>

</form:form>
</div>

<form action="/delete/${book.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input class="delbut" type="submit" value="Delete Book">
						</form>




</body>
</html>