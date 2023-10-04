<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Lists</title>
</head>
<body>
	<form method="post" action="listNavServlet">
	<table>
		<c:forEach items="${requestScope.carLists}" var="currentlist">
		<tr>
			<td><input type="radio" name="id" value="${currentlist.id}"></td>
			<td><h2>${currentlist.listName}</h2></td>
		</tr>
		<tr>
			<td colspan="3">List Date: ${currentlist.listDate}</td>
		</tr>
		<tr>
			<td colspan="3">Region: ${currentlist.region.regionName}</td>
		</tr>
		<c:forEach var="listVal" items="${currentlist.listOfCars}">
		<tr>
			<td></td>
				<td colspan="3">${listVal.brand},${listVal.model}</td>
		</tr>
		</c:forEach>
		</c:forEach>
	</table> 
	<input type="submit" value="delete" name="doThisToList"> 
	<input type="submit" value="add" name="doThisToList">
	</form>
	<a href="addCarsForListServlet">Create a new List</a>
	<a href="index.html">Insert a new car</a>
</body>
</html>