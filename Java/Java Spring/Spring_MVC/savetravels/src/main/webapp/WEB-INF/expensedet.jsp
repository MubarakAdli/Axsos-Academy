<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    <%@ page isErrorPage="true" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.row{
display: flex;
}
</style>

</head>
<body>
	<div class="row">
	<h2>Expense Details</h2>
	<h4><a href="/expenses">Go Back</a></h4>
	 </div>        
   		<h3>Expense Name: <c:out value="${expense.name}"></c:out></h3>
		<h3>Expense Description: <c:out value="${expense.description}"></c:out></h3>
      <h3>Vender: <c:out value="${expense.vendor}"></c:out></h3>
      <h3>Amount Spent: <c:out value="${expense.amount}"></c:out></h3>  
           
                
          
    
        
        
</body>
</html>