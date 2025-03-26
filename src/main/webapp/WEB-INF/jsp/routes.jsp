<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Route Details</title>
<link rel="stylesheet" href="css/style.css">
<script src="https://kit.fontawesome.com/2c135d6bdb.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<header>
		<img alt="logo" src="images/Logo.png" class="logo">
		<div class="signup">
			<a href="admin"><i class="fa fa-home"></i></a>
		</div>
	</header>
	<a href="addroute" class="reg-btn bus-btn"><i class="fas fa-route"></i><i class="fa fa-plus"></i></a>
	<div class="container">
		<table>
		<h1 class="bus-heading form-heading">All Route Details</h1>
			<thead>
				<tr>
					<th>Bus Id</th>
					<th>Registration No</th>
					<th>Bus Type</th>
					<th>From</th>
					<th>To</th>
					<th>Number of Seats</th>
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
						<td><c:out value="${route.busid}" /></td>
						<td><c:out value="${route.regno}" /></td>
						<td><c:out value="${route.type}" /></td>
						<td><c:out value="${route.origin}" /></td>
						<td><c:out value="${route.destination}" /></td>
						<td><c:out value="${route.seats}" /></td>
						<td><c:out value="${route.dateoftravel}" /></td>
						<td><c:out value="${route.departuretime}" /></td>
						<td><c:out value="${route.arrivaltime}" /></td>
						<td><c:out value="${route.fare}" /></td>
						<td><a style="color: red" href="deleteroute/${route.busid}" onclick="return confirm('Are you sure?')" ><i class="fa fa-trash"></i></a></td>
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