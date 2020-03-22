<%@page import="com.renga.mcda5550.bean.Transaction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Transaction</title>
</head>
<body>
<%Transaction transaction = (Transaction)request.getAttribute("transaction") ;%>
<h2 style="color: black;">Please find the transaction details below:</h2>
<table>
<tr>
<th><p style="color: red;">ID</p></th>
<td><p><%=transaction.getID()%></p></td>
</tr>
<tr>
<th><p style="color: red;">Name on Card</p></th>
<td><p><%=transaction.getNameOnCard()%></p></td>
</tr>
<tr>
<th><p style="color: red;">Card Number</p></th>
<td><p><%=transaction.getCardNumber()%></p></td>
</tr>
<tr>
<th><p style="color: red;">Unit Price</p></th>
<td><p><%=transaction.getUnitprice()%></p></td>
</tr>
<tr>
<th><p style="color: red;">Quantity</p></th>
<td><p><%=transaction.getQuantity()%></p></td>
</tr>
<tr>
<th><p style="color: red;">Total Price</p></th>
<td><p><%=transaction.getTotalprice()%></p></td>
</tr>
<tr>
<th><p style="color: red;">Expiry Date</p></th>
<td><p><%=transaction.getExpdate()%></p></td>
</tr>
<tr>
<th><p style="color: red;">Created On</p></th>
<td><p><%=transaction.getCreatedon()%></p></td>
</tr>
<tr>
<th><p style="color: red;">Created By</p></th>
<td><p><%=transaction.getCreatedby()%></p></td>
</tr>
</table>
<br>
<a href="<%=request.getContextPath()%>/Controller?action=home">Home</a>
</body>
</html>