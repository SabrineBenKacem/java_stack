<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
<h1>Fruit Store</h1>
<table class="table table-striped">
<thead>
<tr>
<th>Name </th>
<th> Price </th>
</tr>
</thead>
<tbody>
<c:forEach items="${fruitsList }" var="fruit">

<tr>
<td>${fruit.name}</td>
<td>${fruit.price}</td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>