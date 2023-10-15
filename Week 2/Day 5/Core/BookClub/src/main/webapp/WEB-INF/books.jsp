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
<div class="container">
	<div class="d-flex justify-content-between align-items-center">
		<h1>Welcome, ${user.name } !</h1>
		<a href="/logout">Logout</a>	
	</div>
	<div class="d-flex justify-content-between align-items-center">
		<h3>Books from everyone's shelves:</h3>
		<a href="/books/new">+Add to my shelf!</a>
	</div>
		
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listOfBooks}" var="book">
				<tr>
					<td>${book.id}</td>
					<td><a href="/books/${book.id }">${book.title}</a></td>
					<td>${book.author}</td>
					<td>${book.postedBy.name}</td>
				
				</tr>
			</c:forEach>
		
		</tbody>
	</table>
	
	</div>
   
</body>
</html>