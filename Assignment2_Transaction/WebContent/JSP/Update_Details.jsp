<%@page import="com.renga.mcda5550.bean.Transaction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Details</title>
</head>
<body>
<%Transaction transaction = (Transaction)request.getAttribute("transaction") ;%>
<h2 style="color: black;">Please find the order details below:</h2>
<form action='<%=request.getContextPath()%>/Controller' enctype="multipart/form-data" method='get'>
<table>
<tr>
<th><p style="color: red;">ID</p></th>
<td><input type='number' name='id' value=<%=transaction.getID()%> readonly="readonly"></td>
</tr>
<tr>
<th><p style="color: red;">Name on Card</p></th>
<td><input type='text' name='name' value=<%=transaction.getNameOnCard()%> required="required"></td>
</tr>
<tr>
<th><p style="color: red;">Card Number</p></th>
<td><input type='text' name='cardnumber' value=<%=transaction.getID()%> required="required"></td>
</tr>
<tr>
<th><p style="color: red;">Unit Price</p></th>
<td><input type='number' name='unitprice' value=<%=transaction.getUnitprice()%> required="required"></td>
</tr>
<tr>
<th><p style="color: red;">Quantity</p></th>
<td><input type='number' name='quantity' value=<%=transaction.getQuantity()%> required="required"></td>
</tr>
<tr>
<th><p style="color: red;">Total Price</p></th>
<td><input type='number' name='totalprice' value=<%=transaction.getTotalprice()%> required="required"></td>
</tr>
<tr>
<th><p style="color: red;">Expiry Date</p></th>
<td><input type='text' name='expiry' value=<%=transaction.getExpdate()%> required="required"></td>
</tr>
<tr>
<th><p style="color: red;">Created On</p></th>
<td><input type="date" name='createdon' value=<%=transaction.getCreatedon()%> readonly="readonly"></td>
</tr>
<tr>
<th><p style="color: red;">Created By</p></th>
<td><input type='text' name='createdby' value=<%=transaction.getCreatedby()%> required="required"></td>
</tr>
</table>
<input type='submit' value='updatedetails' name='action'>

</form>
</body>
</html>