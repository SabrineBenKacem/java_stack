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
   <div class="login-reg-main border-round give-me-space-up-down">
   <h1>Change your Entry</h1>
   <a href="/books">back to the shelves</a>

			
			<form:form action="/books/${book.id }/edit" method="post" modelAttribute="book">
			<input type="hidden" name="_method" value="put">
				<div class="form-group">
					<label> Title:</label>
					<form:input path="title" class="form-control" />
					<form:errors path="title" class="text-danger" />
				</div>
				<div class="form-group">
					<label>Author:</label>
					<form:input path="author" class="form-control" />
					<form:errors path="author" class="text-danger" />
				</div>
				<div class="form-group">
					<label>My Thoughts:</label>
					<form:input path="thoughts" class="form-control" />
					<form:errors path="thoughts" class="text-danger" />
				</div>
				
				<input type="submit" value="Submit" class="btn btn-primary" />
			</form:form>
		</div>
		</div>
</body>
</html>