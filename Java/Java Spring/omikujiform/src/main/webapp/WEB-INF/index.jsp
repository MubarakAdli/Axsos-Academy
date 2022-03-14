<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Send an Omikuji!</h2>
<form action="/login" method="post">

        
        <div>Pick a number between 10 and 25</div>
  		<label for="number"></label>
		<input type="number" name="number" id="number" min="5" max="25" />									
        <div>Enter the name of any city</div>
        <input type="text" name="city" id="">
        <div>Enter the name of any real person</div>
        <input type="text" name="name" id="">
        <div>Enter a professional hobby</div>
        <input type="text" name="hoppy" id="">
        <div>Enter any type of living thing</div>
        <input type="text" name="living" id="">
        <div>Say something nice to someone</div>
        <textarea name="comment" cols="20" rows="3"></textarea>
        <div>Send and show a friend</div>
        <button type="submit">Send</button>
    </form>
</body>
</html>