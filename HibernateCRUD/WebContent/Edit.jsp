<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/UserController" method="post">
<br>
<table align="center" border="5" cellspacing="5" cellpadding="5" bordercolor="gray">

<tr>
<td colspan="2" align="center">
<h2><b>
Edit Your Data
</b></h2>
</td>
</tr>
<c:forEach items="${sessionScope.edituser}" var="i">
<tr>
<td>First Name :</td>
<td><input type="text" name="fname" value="${i.fname }"></td>
</tr>

<tr>
<td>Last Name :</td>
<td><input type="text" name="lname" value="${i.lname }"></td>
</tr>

<tr>
<td>User Name :</td>
<td><input type="text" name="uname" value="${i.uname }"></td>
</tr>

<tr>
<td>Password :</td>
<td><input type="password" name="pwd" value="${i.pwd }"></td>
</tr>

 
<tr >

<td align="center" colspan="2">
<input type="hidden" name="flag" value="update">
<input type="hidden" name="id" value="${i.id }">

<input type="submit" name="Submit"> </td>
</tr>
</c:forEach>
</table>

</form>
</body>
</html>