<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success</title>
</head>
<body>
<%String message=(String)request.getAttribute("message"); %>
<h2 style="color: black;"> <%=message %></h2>
<br>
<a href="<%=request.getContextPath()%>/Controller?action=home">Home</a>
</body>
</html>