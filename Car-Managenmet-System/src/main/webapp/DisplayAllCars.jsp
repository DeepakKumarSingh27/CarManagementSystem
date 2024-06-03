<%@page import="com.jsp.servlet.carproject.Car"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <% List<Car> cars=(List) request.getAttribute("carList"); %>
     <table border="">
     <tr>
         <th>CarId</th>
         <th>CarModel</th>
         <th>CarBrand</th>
         <th>CarPrice</th>
         <th>CarUpdate</th>
         <th>CarDelete</th>
     </tr>
     <% 
          for (Car car: cars){  
     %>
     <tr>
     <td><%=car.getCarId()%></td>
     <td><%=car.getCarModel()%></td>
     <td><%=car.getCarBrand()%></td>
     <td><%=car.getCarPrice()%></td>
     <td><a href="updateCar?carId<%=car.getCarId()%>"></a></td>
     
     </tr>
     <%}%>
     </table>
</body>
</html>