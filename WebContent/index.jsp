<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Details</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
<center>
<div class="tron"><h1>Add New Employee</h1></div>
<form action="Controller" method="post" style="background-color:aqua; width: 80%; padding:10px; margin: 10px;" >
Id:<input type="text" name="id"><br><br>
Name :<input type="text" name="name"><br><br>
Country:<input type="text" name="country"><br><br>
State:<input type="text" name="state"><br><br>
<input type="submit" style="background-color:skyblue" value="Save">
</form>
</center>
<br><br>
<a href="view.jsp" class="btn btn-primary">View data</a>
<!--
<a href="editform.jsp" class="btn btn-primary">Update data</a> 
 -->
<a href="delete.jsp" class="btn btn-primary">Delete data</a>

</body>
</html>