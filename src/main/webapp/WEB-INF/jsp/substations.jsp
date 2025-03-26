<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All PickUp/Drop Points Details</title>
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
	<a href="addsubstation" class="reg-btn bus-btn"><i class="fa fa-terminal"></i></a>
	<div class="container">
		<table>
		<h1 class="bus-heading form-heading">All Sub-Stations Details</h1>
			<thead>
				<tr>
					<th>Sub-Station Id</th>
					<th>Sub-Station Name</th>
					<th>Sub-Station Contact No.</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${stations}" var="station">
					<tr>
						<td><c:out value="${station.substationid}" /></td>
						<td><c:out value="${station.substationname}" /></td>
						<td><c:out value="${station.substationcontact}" /></td>
						<td><a style="color: red" href="deletestation/${station.substationid}" onclick="return confirm('Are you sure?')" ><i class="fa fa-trash"></i></a></td>
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