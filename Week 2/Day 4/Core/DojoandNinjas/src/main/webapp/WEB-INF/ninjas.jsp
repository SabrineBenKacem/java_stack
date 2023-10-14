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
   <h1>New Ninja</h1>
   
   <form:form action="/ninjas/new" method="post" modelAttribute="ninja" class="col-3">
<form:errors path="*"/> 
 <p>
	<form:select path="dojo" lass="dropdown" class="form-select" >
	<c:forEach items="${dojosList }" var="oneDojo">
		<form:option value="${oneDojo.id }">${oneDojo.name }</form:option>
	</c:forEach>
	
	</form:select>
    </p>    

    <p >
        <form:label path="firstName" class="form-label">First Name:</form:label>
       
        <form:input class="form-control" path="firstName"/>
    </p>
     <p >
        <form:label path="lastName" class="form-label">Last Name:</form:label>
       
        <form:input class="form-control" path="lastName"/>
    </p>
      <p >
        <form:label path="age" class="form-label">Age:</form:label>
       
        <form:input type="number" class="form-control" path="age"/>
    </p>
     <button class="btn btn-success">Create</button>
     </form:form>    
   
   </div>
</body>
</html>