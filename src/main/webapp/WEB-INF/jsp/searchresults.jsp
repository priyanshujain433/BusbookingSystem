<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Available Route Details</title>
<link rel="stylesheet" href="css/style.css">
<script src="https://kit.fontawesome.com/2c135d6bdb.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<header>
		<img alt="logo" src="images/Logo.png" class="logo">
		<div class="signup">
			<a href="home"><i class="fa fa-home"></i></a>
		</div>
	</header>
	<a href="searchroutes" class="reg-btn bus-btn"><i class="fas fa-search"></i></a>
	<div class="container">
		<table>
		<h1 class="bus-heading form-heading">Available Buses</h1>
			<thead>
				<tr>
					<th>Bus Type</th>
					<th>From</th>
					<th>To</th>
					<th>Date</th>
					<th>Departure</th>
					<th>Arrival</th>
					<th>Ticket Fare</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${routes}" var="route">
					<tr>
						<td><c:out value="${route.type}" /></td>
						<td><c:out value="${route.origin}" /></td>
						<td><c:out value="${route.destination}" /></td>
						<td><c:out value="${route.dateoftravel}" /></td>
						<td><c:out value="${route.departuretime}" /></td>
						<td><c:out value="${route.arrivaltime}" /></td>
						<td><c:out value="${route.fare}" /></td>
						<td><a style="color: white" href="selectroute/${route.busid}" onclick="return confirm('Are you sure?')" ><i class="fa fa-check"></i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<footer>
		<small>© 2022 DXCTechnology.</small>
	</footer>
</body>
</html>