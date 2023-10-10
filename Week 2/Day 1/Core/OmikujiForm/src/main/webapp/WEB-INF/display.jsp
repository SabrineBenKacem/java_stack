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
<title>Insert title here</title>
</head>
<body>
<h1>Here's Your Omikuji!</h1>
<div>
<p>
In 
<c:out value="${keyNumber }"></c:out>
years, you will live in 
<c:out value="${keyCity }"></c:out>
with 
<c:out value="${keyName }"></c:out>
as your roommate,
<c:out value="${keyHobby }"></c:out>
for living. The next time you see a 
<c:out value="${keyLivingThing }"></c:out>
, you will have good luck. <br>
Also, <c:out value="${keySomething }"></c:out>
</p>
</div>
<a href="/omikuji">Go Back</a>
</body>
</html>