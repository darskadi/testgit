<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/UserController" method="post">
<br>
<table align="center" border="5" cellspacing="5" cellpadding="5" bordercolor="gray">

<tr>
<td colspan="2" align="center">
<h2><b>
<%
String insert = (String)session.getAttribute("insert");
if(insert == null)
{
%>
Insert Your Data Here
<%

}
else
{
	out.println(insert);
	session.removeAttribute("insert");
}
	
%>
</b></h2><a href="Index.jsp">Index</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath() %>/UserController?flag=view">View</a>
</td>
</tr>

<tr>
<td>First Name :</td>
<td><input type="text" name="fname"></td>
</tr>

<tr>
<td>Last Name :</td>
<td><input type="text" name="lname"></td>
</tr>

<tr>
<td>User Name :</td>
<td><input type="text" name="uname"></td>
</tr>

<tr>
<td>Password :</td>
<td><input type="password" name="pwd"></td>
</tr>


<tr >
<td align="center" colspan="2">
<input type="submit" name="Submit"> 
<input type="hidden" name="flag" value="add">
 <input type="reset" name="Reset"></td>
</tr>

</table>
</form>
</body>
</html>