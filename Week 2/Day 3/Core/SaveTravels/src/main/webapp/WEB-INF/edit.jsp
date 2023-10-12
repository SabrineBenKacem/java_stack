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
<div class="d-flex justify-content-between">
<h1>Edit Expense</h1>
<a href="/expenses">Go back</a>
</div>
<form:form action="/expenses/edit/${expense.id }" method="post" modelAttribute="expense">
<input type="hidden" name="_method" value="put">
<form:errors path="*"/> 
    <p>
        <form:label path="expenseName">Expense Name:</form:label>
       
        <form:input path="expenseName"/>
    </p>
    <p>
        <form:label path="vendor">Vendor:</form:label>
        
        <form:input path="vendor"/>
    </p>

    <p>
        <form:label path="amount">Amount:</form:label>    
        <form:input type="number" path="amount"/>
    </p>    
    <p>
	 <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>    
    
    <input type="submit" value="Submit"/>
</form:form> 
 </div>  
   
</body>
</html>