<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Bus Details</title>
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
	<a href="addbus" class="reg-btn bus-btn"><i class="fas fa-bus"></i><i class="fa fa-plus"></i></a>
	<div class="container">
		<table>
		<h1 class="bus-heading form-heading">All Bus Details</h1>
			<thead>
				<tr>
					<th>Bus Id</th>
					<th>Bus Type</th>
					<th>Number of Seats</th>
					<th>Registration No</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${buses}" var="bus">
					<tr>
						<td name="busid"><c:out value="${bus.busid}" /></td>
						<td><c:out value="${bus.type}" /></td>
						<td><c:out value="${bus.seats}" /></td>
						<td><c:out value="${bus.regno}" /></td>
						<td><a style="color: red" href="deletebus/${bus.busid}" onclick="return confirm('Are you sure?')" ><i class="fa fa-trash"></i></a></td>
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