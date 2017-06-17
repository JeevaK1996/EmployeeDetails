<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dao.*,bean.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>
<%
	String id=request.getParameter("id");
	Employee e=DatabaseMysql.getElementById(Integer.parseInt(id));
%>
<center>
<form action="update.jsp" method="get">
Id:<input type="text" name="id" value="<%=e.getId() %>"/><br>
Name<input type="text" name="name" value="<%= e.getName()%>"/><br>
Country<input type="text" name="country" value="<%=e.getCountry()%>"/><br>
State<input type="text" name="state" value="<%= e.getState()%>"/><br>
<input type="submit" value="Update" class="btn btn-success"/>
</form>
</center>
</body>
</html>