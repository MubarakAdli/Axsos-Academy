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
    margin-left: -45px;
}

.top{
display: flex;
justify-content: center;
}
</style>
</head>
<body>

        	<div class="top">
        	<div></div>
            <h4> <a href="/languages">Dashboard</a></h4>
            </div>
           		<div>
                <h4><c:out value="${language.name}"></c:out></h4>
       			<h4><c:out value="${language.creator}"></c:out></h4>
               <h4> <c:out value="${language.version}"></c:out></h4>
               
               <p><a href="/languages/edit/${language.id}">Edit</a></p>
               <form action="/languages/${language.id}" method="post">
						    <input type="hidden" name="_method" value="delete">
						    <input class="but" type="submit" value="Delete">
						</form>
               </div>
        

</body>
</html>