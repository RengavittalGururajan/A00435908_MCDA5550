<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Transaction</title>
</head>
<body>
<%String message=(String)request.getAttribute("message"); 
if(message!=null)
{
%>
<h2 style="color: red;">
<%=message %>
</h2>
<%} %>
<h2 style="color: black;">Enter the Transaction ID to be deleted</h2>
<form action='<%=request.getContextPath()%>/Controller' enctype="multipart/form-data" method='get'>

<table>
<tr><td><p>ID</p></td><td><input type='number' name='id' required></td></tr>

</table>

<input type='submit' value='DeleteTransaction' name='action'>

</form>
<br>
<a href="<%=request.getContextPath()%>/Controller?action=home">Home</a>
</body>
</html>