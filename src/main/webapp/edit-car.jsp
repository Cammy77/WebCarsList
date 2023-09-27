<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit vehicle details here</title>
</head>
<body>
	<form action="editCarServlet" method="post">
		Brand: <input type="text" name="brand" value="${carToEdit.brand}">
		Model: <input type="text" name="model" value="${carToEdit.model}">
		<input type="hidden" name="id" value="${carToEdit.id}"> <input
			type="submit" value="Save Edited Vehicle">
	</form>
</body>
</html>