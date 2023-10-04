<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Make a new list</title>
</head>
<body>
	<form action="createNewListServlet" method="post">
		List Region: <input type="text" name="listName"><br /> 
		date: <input type="text" name="month" placeholder="mm" size="4">
			  <input type="text" name="day" placeholder="dd" size="4">, 
			  <input type="text" name="year" placeholder="yyyy" size="4">
		Region: <input type="text" name="region.regionName"><br />
		Cars:<br /> <select name="allCarsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allCars}" var="currentcar">
				<option value="${currentitem.id}">${currentitem.brand} ${currentitem.model}</option>
			</c:forEach>
		</select> <br /> <input type="submit" value="Create List and Add Cars">
	</form>
	<a href="index.html">Add new cars.</a>
</body>
</html>