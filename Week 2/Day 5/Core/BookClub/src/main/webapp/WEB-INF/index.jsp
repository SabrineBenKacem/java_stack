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
   <h1>Book Club</h1>
   <p> A place for friends to share thoughts on books.</p>
			<h3>Register:</h3>
			<form:form action="/register" 
			method="post" modelAttribute="newUser">
				<div class="form-group">
					<label> Name:</label>
					<form:input path="name" class="form-control" />
					<form:errors path="name" class="text-danger" />
				</div>
				<div class="form-group">
					<label>Email:</label>
					<form:input path="email" class="form-control" />
					<form:errors path="email" class="text-danger" />
				</div>
				<div class="form-group">
					<label>Password:</label>
					<form:password path="password" class="form-control" />
					<form:errors path="password" class="text-danger" />
				</div>
				<div class="form-group">
					<label>Confirm Password:</label>
					<form:password path="confirmPassword" class="form-control" />
					<form:errors path="confirmPassword" class="text-danger" />
				</div>
				<input type="submit" value="Register" class="btn btn-primary" />
			</form:form>
		</div>

		<!-- LOGIN -->
		<!-- newLogin object will touch the model to validate only -->
		<div class="login-reg-main border-round">
			<h3>Login:</h3>
			<form:form action="/login" method="post" 
			modelAttribute="newLoginUser">
				<div class="form-group">
					<label>Email:</label>
					<form:input path="email" class="form-control" />
					<form:errors path="email" class="text-danger" />
				</div>
				<div class="form-group">
					<label>Password:</label>
					<form:password path="password" class="form-control" />
					<form:errors path="password" class="text-danger" />
				</div>
				<input type="submit" value="Login" class="btn btn-success" />
			</form:form>
		</div>
   
   </div>
</body>
</html>