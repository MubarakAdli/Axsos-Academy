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
body{
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

<div>
<h1>Book Club</h1>
<h3>A place for friends to share thougts and books</h3>
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
<button type="submit" class="btn btn-primary">Submit</button>

</form:form>
</div>



<div>
<h1 class="white">Welcome!</h1>
<h3 class="white">Join Our community</h3>
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
<button type="submit" class="btn btn-primary">Submit</button>

</form:form>
</div>
</body>
</html>
