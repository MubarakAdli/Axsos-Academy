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

.top{text-align: center;
}
h1{color: #a113ff;
}
main{
display: flex;
justify-content: space-around;
}
.btn{
margin-left: 190px;
margin-top: 10px;
}
.form-group{
display: flex;
justify-content: space-between;
margin-top: 10px;
}
.white{color: white;
}
</style>
</head>
<body>

<div class="top">
<h1>Project Manager</h1>
<h3>a place for teams to manage projects</h3>
</div>

<main>
<div>
<h2>Register</h2>
<form:form action="/register" method="post" modelAttribute="newUser">
<div class="form-group">
<label>User Name:</label>
<form:input path="userName" class="form-control" />
<form:errors path="userName" class="text-danger" />
</div>
<div class="form-group">
<label>Email:</label>
<form:input path="email" class="form-control" />
<form:errors path="email" class="text-danger" />
</div>
<div class="form-group">
<label>Password:</label>
<form:password path="password" class="form-control" />
<form:errors path="password" class="text-danger" />
</div>
<div class="form-group">
<label>Confirm Password:</label>
<form:password path="confirm" class="form-control" />
<form:errors path="confirm" class="text-danger" />
</div>
<input type="submit" value="Register" class="btn btn-primary" />
</form:form>
</div>



<div>
<h2>Login</h2>

<form:form action="/login" method="post" modelAttribute="newLogin">
<div class="form-group">
<label>Email:</label>
<form:input path="email" class="form-control" />
<form:errors path="email" class="text-danger" />
</div>
<div class="form-group">
<label>Password:</label>
<form:password path="password" class="form-control" />
<form:errors path="password" class="text-danger" />
</div>
<input type="submit" value="Login" class="btn" />
</form:form>
</div>
</main>
</body>
</html>