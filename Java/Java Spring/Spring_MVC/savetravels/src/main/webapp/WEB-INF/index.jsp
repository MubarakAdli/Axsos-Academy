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

		h1{
			color: #085394
			}
			
		h2{
			color: #085394}

        table,tr,td,th{
            border: 1px solid black;
        }

        table{
            margin-bottom: 20px;
            width: 660px;
        }
        
        .sub {
        color:white;
        background-color: #085394;
			margin-left: 190px;
			}
			
			.red{
			color: red;
			}
    </style>
</head>
<body>
<h2>Save Travels</h2>
        <table>
            <tr>
                <th>Expense</th>
                <th>Vendor</th>
                <th>Amount</th>
                
            </tr>
           <c:forEach var="oneexpense" items="${expenses}">
            <tr>
                <td><c:out value="${oneexpense.name}"></c:out></td>
       			<td><c:out value="${oneexpense.vendor}"></c:out></td>
                <td><c:out value="${oneexpense.amount}"></c:out></td>
            </tr>
            </c:forEach>
        </table>
        
        <h2>Add an Expense</h2>
<form:form action="/expenses" method="post" modelAttribute="expense">
    <input type="hidden" name="_method" value="post">
    <p>
        <form:label path="name">Expense</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors class="red" path="vendor"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
             
        <form:input type="number" path="amount"/>
    </p>  
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>  
    <input class="sub" type="submit" value="Submit"/>
</form:form>

</body>
</html>