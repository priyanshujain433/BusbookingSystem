<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Ticket Details</title>
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
	<div class="container">
		<table>
		<h1 class="bus-heading form-heading">All Ticket Details</h1>
			<thead>
				<tr>
					<th>Ticket ID</th>
					<th>From</th>
					<th>To</th>
					<th>Date</th>
					<th>Departure</th>
					<th>Ticket Fare</th>
					<th>User</th>
					<th>View</th>
					<th>Cancel</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tickets}" var="ticket">
					<tr>
						<td><c:out value="${ticket.ticketid}" /></td>
						<td><c:out value="${ticket.origin}" /></td>
						<td><c:out value="${ticket.destination}" /></td>
						<td><c:out value="${ticket.date}" /></td>
						<td><c:out value="${ticket.dtime}" /></td>
						<td><c:out value="${ticket.totalfare}" /></td>
						<td><c:out value="${ticket.userid}" /></td>
						<td><a style="color: white" href="viewticket/${ticket.ticketid}" onclick="return confirm('Are you sure?')" ><i class="fa fa-eye"></i></a></td>
						<td><a style="color: red" href="cancelticket/${ticket.ticketid}" onclick="return confirm('Are you sure?')" ><i class="fa fa-times"></i></a></td>
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