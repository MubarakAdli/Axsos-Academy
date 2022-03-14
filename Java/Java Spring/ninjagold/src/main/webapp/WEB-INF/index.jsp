<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<body>
    <div class="gold">
        <h3>Your Gold</h3>
        <div class="goldbox"><p id="gold"><c:out value="${gold}"/></p></div>
    </div>
    <div class="container">
        <div class="box">
            <form action="/process_money" method="post">
               
                <input type="hidden" name="which_form" value="farm">
                <h3>Farm</h3>
            <p>(earns 10-20 coins)</p>
            <button>Find Gold!</button>
            </form>
        </div>
        <div class="box">
            <form action="/process_money" method="post">
           
                <input type="hidden" name="which_form" value="cave">
                <h3>Cave</h3>
            <p>(earns 10-20 coins)</p>
            <button>Find Gold!</button>
            </form>
        </div>
        <div class="box">
            <form action="/process_money" method="post">
                <input type="hidden" name="which_form" value="house">
                <h3>House</h3>
            <p>(earns 10-20 coins)</p>
            <button>Find Gold!</button>
            </form>
        </div>
        <div class="box">
            <form action="/process_money" method="post">
                <input type="hidden" name="which_form" value="casino">
                <h3>Quest</h3>
            <p>(earns/takes 0-50 coins)</p>
            <button>Find Gold!</button>
            </form>
        </div>
    </div>
    <p>Activites</p>
    <div class="bottom">
    <% ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");%>
    					
    					<% for(String activity : activities) {%>
    					<p><%= activity %></p>
    					<% }%>
        
    </div> 
</body>
</html>