<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit vehicle details here</title>
<script type="text/javascript">
	function validate(){
		if(document.editCar.brand.value == ""){
			alert("Enter a Brand!");
			document.editCar.brand.focus();
			return false;
		}if(document.editCar.model.value == ""){
			alert("Enter a Model!");
			document.editCar.model.focus();
			return false;
		}else{
			return (true);
		}
	}
</script>
</head>
<body>
	<form action="editCarServlet" name="editCar" onsubmit="return(validate());" method="post">
		Brand: <input type="text" name="brand" value="${carToEdit.brand}">
		Model: <input type="text" name="model" value="${carToEdit.model}">
		<input type="hidden" name="id" value="${carToEdit.id}"> <input
			type="submit" value="Save Edited Vehicle">
	</form>
	<a href="index.html">Add new cars.</a>
</body>
</html>