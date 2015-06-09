<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select The Operation</title>
</head>
<body>

<br>
<table align="center" border="5" cellspacing="5" cellpadding="5" bordercolor="gray">

<tr>
<td colspan="2" align="center">
<h2><b>
Hibernate CRUD </br>
Select Your  Operation
</b></h2>
</td>
</tr>

<tr>
<td align="right">Insert :</td>
<td align="left"><a href="insert.jsp"> Insert</a></td>

</tr>

<tr>
<td align="right">View :</td>
<td align="left"><a href="<%=request.getContextPath() %>/UserController?flag=view"> View</a></td>
</tr>



</table>

</body>
</html>