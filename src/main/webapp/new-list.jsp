<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Make a new list</title>
<script type="text/javascript">
	function validate(){
		if(document.newList.listName.value == ""){
			alert("Enter a name!");
			document.newList.listName.focus();
			return false;
		}if(document.newList.month.value == ""){
			alert("Enter a month!");
			document.newList.month.focus();
			return false;
		}if(document.newList.day.value == ""){
			alert("Enter a day!");
			document.newList.day.focus();
			return false;
		}if(document.newList.year.value == ""){
			alert("Enter a year!");
			document.newList.year.focus();
			return false;
		}else{
			return (true);
		}
	}
</script>
</head>
<body>
	<form action="createNewListServlet" name="newList" onsubmit="return(validate());" method="post">
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