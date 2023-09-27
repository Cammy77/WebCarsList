<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Our Car List</title>
</head>
<body>
	<form method="post" action="navServlet">
		<table>
			<c:forEach items="${requestScope.allCars}" var="currentcar">
				<tr>
					<td><input type="radio" name="id" value="${currentcar.id}"></td>
					<td>${currentcar.brand}</td>
					<td>${currentcar.model}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToCar"> <input
			type="submit" value="delete" name="doThisToCar"> <input
			type="submit" value="add" name="doThisToCar">
	</form>
</body>
</html>