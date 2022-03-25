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
	
	.top-2{display: flex;
	align-items: center;
	
	}
	.top-1{margin-left: 200px;
	
	}
	
	.new-project{
    border: 2px solid black;
    color: black;
    text-decoration: none;
}
	
	table,tr,td,th{
            border: 1px solid black;
            text-align: center;
        }
        table{
            margin-bottom: 20px;
            width: 660px;
        }
        
        .but{
        border: none;
        text-decoration: underline;
        background-color: white;}
	</style>
</head>
<body>
	<div class="top">
	<h1>Welcome, <c:out value="${loggedUser.userName}" /></h1>
	<h3 class="top-1"><a href="/logout">Logout</a></h3>
	</div>
	<div class="top-2">
	<h3>All Projects</h3>
	<h3  class="top-1"><a class="new-project" href="/projects/new">+new project</a></h3>
	</div>
	<table>
		<tr>
			<th>Project</th>
			<th>Team Lead</th>
			<th>Due Date</th>
			<th>Actions</th>

		</tr>
		<c:forEach var="project" items="${allProjects}">
			<tr>
				<td><a href="/projects/${project.id}"><c:out value="${project.title}"></c:out></a></td>
				 <td><c:out value="${project.user.userName}"></c:out></td>
				<td><c:out value="${project.dueDate}"></c:out></td>
				<td><form action="/join/${project.id}" method="post">
						    <input type="hidden" name="_method" value="put">
						    <input class="but" type="submit" value="Join team">
						</form></td>
			</tr>
		</c:forEach>
	</table>
	
	<h3>Your Projects</h3>
	<table>           
		<tr>
			<th>Project</th>
			<th>Lead</th>
			<th>Due Date</th>
			<th>Actions</th>

		</tr>
		
		<c:forEach var="project" items="${createdProjects}">
		<tr>
				<td><a href="/projects/${project.id}"><c:out value="${project.title}"></c:out></a></td>
				 <td><c:out value="${project.user.userName}"></c:out></td>
				<td><c:out value="${project.dueDate}"></c:out></td>
				<td><c:choose>
				<c:when test="${loggedUser.id !=project.user.id}">
				<form action="/leave/${project.id}" method="post">
						    <input type="hidden" name="_method" value="Put">
						    <input class="but" type="submit" value="leave team">
						</form>
				</c:when>
				<c:otherwise>
				<a href="/projects/${project.id}/edit">edit</a>
				</c:otherwise>
				</c:choose>
				</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>