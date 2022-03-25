<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Welcome</title>
	
	<style>
	.top{display: flex;
	align-items: center;
	
	}
	a{margin-left: 120px;
	}
	
	.delbut {background: red;
    color: white;
	
}
	</style>
</head>
<body>
	<div class="top">
	<h1>Project Details</h1>
	<h3><a href="/dashboard">Back to Dashboard</a></h3>
	</div>
				<h3><c:out value="${project.title}"></c:out></h3>
				 <h3><c:out value="${project.description}"></c:out></h3>
				<h3><c:out value="${project.dueDate}"></c:out></h3>
				
				
				<form action="/delete/${project.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input class="delbut" type="submit" value="Delete Project">
						</form>	
				
</body>
</html>