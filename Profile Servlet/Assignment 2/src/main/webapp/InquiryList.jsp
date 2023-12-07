<%@page import="bean.Inquiry"%>
<%@page import="dbConnection.ConnectionManager"%>
<%@page import="DAO.InqDAO"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<title>Inquiry List</title>
	</head>
<body>
	<div class="w3-container w3-margin">
		<header class="w3-container w3-light-blue">
			<div class="w3-container w3-center w3-wide w3-animate-fading">
				<h1><b>Inquiry List</b></h1>
			</div>
		</header>
		<div class="w3-panel w3-padding-large w3-container">
		<!-------inquiry details table-------->
		<table class="w3-table-all w3-centered">
			<tr class="w3-pale-green">
				<th>NAME</th>
				<th>EMAIL</th>
				<th>MESSAGE</th>
			</tr>
			<c:forEach items="${listInq}" var="db"
				varStatus="message">
		<!------displaying inquiry details------>
			<tr>
				<td>${db.name}</td>
				<td>${db.email}</td>
				<td>${db.message}</td>
<!------edit button---->
<!--delete booking button--->
			</tr>
			</c:forEach>
		</table>
		
<div class="w3-panel">
<a href="profile.jsp" class="w3-button w3-block w3-teal w3-hover-
grey">Back to Homepage</a>
</div>
</div>
</div>
</body>
</html>