<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Transaction</title>
</head>
<body>
<br>
<a href="<%=request.getContextPath()%>/Controller?action=home">Home</a>
<br>
<h2 style="color: black;">Please enter the below details to insert a Transaction</h2>
<form action='<%=request.getContextPath()%>/Controller' enctype="multipart/form-data" method='get'>

<table>
<tr><td><p>ID</p></td><td><input type='number' name='id' required></td></tr>
<tr><td><p>Name on Card</p></td><td><input type='text' name='name' required></td></tr>
<tr><td><p>Card Number</p></td><td><input type='text' name='cardnumber' required></td></tr>
<tr><td><p>Unit Price</p></td><td><input type='number' name='unitprice' required></td></tr>
<tr><td><p>Quantity</p></td><td><input type='number' name='quantity' required></td></tr>
<tr><td><p>Total Price</p></td><td><input type='number' name='totalprice' required></td></tr>
<tr><td><p>Expiration Date</p></td><td><input type='text' name='expiry' required></td></tr>
<tr><td><p>Created By</p></td><td><input type='text' name='createdby' required></td></tr>

</table>

<input type='submit' value='addtransaction' name='action'>

</form>

</body>
</html>