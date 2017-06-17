<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="dao.DatabaseMysql"%>
<jsp:useBean id="u" class="bean.Employee"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<% 
DatabaseMysql.delete(u);
response.sendRedirect("view.jsp");
%>