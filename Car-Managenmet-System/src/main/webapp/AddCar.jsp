<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Enter Car Details</h2>
	<form action="AddNewCar" method="post">
		<input type="number" placeholder="Enter CarId" name="carId"><br>
		<input type="text" placeholder="Enter CarModel" name="carModel"><br>
		<input type="text" placeholder="Enter CarBrand" name="carBrand"><br>
		<input type="number" placeholder="Enter CarPrice" name="carPrice"><br>
		<input type="submit" value="Add">
	</form>

</body>
</html>