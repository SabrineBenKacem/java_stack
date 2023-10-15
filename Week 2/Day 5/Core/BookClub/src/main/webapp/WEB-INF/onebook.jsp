<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tacos</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
   <div class= "container">
   <div class ="d-flex justify-content-between">
   <h1> ${book.title }</h1>
   <a href="/books">back to the shelves</a>
   </div>
   <c:if test="${loggedUser.id eq book.postedBy.id }">
   <h2>You read ${book.title } by ${book.author }.</h2>
   <h2>Here are you thoughts:</h2>
   
   </c:if>
   
   <c:if test="${loggedUser.id != book.postedBy.id }">
   <h2>${book.postedBy.name } read ${book.title } by ${book.author }.</h2>
   <h2>Here are ${book.postedBy.name }'s thoughts</h2>
   </c:if>
   <hr>
   <p> ${book.thoughts }
   <hr>
    <div class ="d-flex justify-content-around">
   <c:if test="${loggedUser.id eq book.postedBy.id }">
		<a href="/books/${book.id }/edit" class="btn btn-secondary">edit</a> 
		<form action="/books/${book.id }" method="post">
		<input type="hidden" name="_method" value="delete"/>
		<button class="btn btn-danger ms-3">delete</button>
		</form>
		</c:if>
		</div>
   </div>
</body>
</html>