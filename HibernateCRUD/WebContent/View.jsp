<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String delete = (String)session.getAttribute("delete");
String update = (String)session.getAttribute("update");
if(delete != null)
{
	out.print("<script>window.alert('Record Has Been Deleted Sucessfully')</script>");
	session.removeAttribute("delete");
}
if(update != null)
{
	out.print("<script>window.alert('Record Has Been Updated Sucessfully')</script>");
	session.removeAttribute("update");
}
%>
<br>
<table align="center" border="5" cellspacing="5" cellpadding="5" bordercolor="gray">

<tr>
<td colspan="6" align="center">
<h2><b>
User Data 
</b></h2><a href="Index.jsp">Index</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="insert.jsp">Insert</a>
</td>
</tr>

<tr>
<td>Id</td>
<td>First Name</td>
<td>Last Name</td>
<td>User Name</td>
<td>Edit</td>
<td>Delete</td>
</tr>
<%
int i =1;
%>
<c:forEach items="${sessionScope.user}" var="i">
<tr>
<td> <% out.print(i); i++; %> </td>
<td>${i.fname }</td>
<td>${i.lname }</td>
<td>${i.uname }</td>
<td><a href="<%=request.getContextPath() %>/UserController?flag=edit&id=${i.id }">Edit</a></td>
<td><a href="<%=request.getContextPath() %>/UserController?flag=delete&id=${i.id }" onclick="return confirm('Are You Sure You Want To Delete?')">Delete</a></td>
</tr>
</c:forEach>

</table>

</body>
</html>