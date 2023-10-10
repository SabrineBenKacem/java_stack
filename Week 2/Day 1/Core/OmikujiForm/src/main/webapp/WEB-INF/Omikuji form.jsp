<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
<meta charset="ISO-8859-1">
</head>
<body>
<h1>Send an Omikuji!</h1>
<c:if test="${fn:length(numberErr)>0}">
<div class="alert alert-danger" role="alert">${numberErr }</div>
</c:if>
	
<form action="/processOmikuji" method="POST">

		Pick any number from 5 to 25 <br />
		<input type ="number" name="number" /> <br />
		<br />
		
		Enter the name of any city <br />
		<input name="city" /> <br />
		<br />
		
		Enter the name of any real person <br />
		<input  name="name" /> <br />
		<br />
		
		Enter professional endeavor or hobby <br />
		<input  name="hobby" />
		<br>
		Enter any type of living thing
		<br>
		<input name ="livingThing"/>
		<br>

		Say something nice to someone
		<br>
		<textarea name ="something" rows =30></textarea>
	
		<br>
		<h3>Send and show a friend</h3>

		
		<button  type="submit">Send</button>
	</form>
</body>
</html>