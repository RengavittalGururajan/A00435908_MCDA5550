<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h1>Transaction Database Information</h1>
<br>
<a href="<%=request.getContextPath()%>/Controller?action=insert">Insert Transaction</a>
<br>
<a href="<%=request.getContextPath()%>/Controller?action=retrieve">Retrieve Transaction</a>
<br>
<a href="<%=request.getContextPath()%>/Controller?action=update">Update Transaction</a>
<br>
<a href="<%=request.getContextPath()%>/Controller?action=delete">Delete Transaction</a>
</body>
</html>