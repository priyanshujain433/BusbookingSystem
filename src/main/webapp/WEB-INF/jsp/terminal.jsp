<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Terminal Details</title>
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
	<a href="addterminal" class="reg-btn bus-btn"><i class="fas fa-stop-circle"></i> <i class="fa fa-plus"></i></a>
	<div class="container">
		<table>
		<h1 class="bus-heading form-heading">All Terminal Details</h1>
			<thead>
				<tr>
					<th>Terminal Id</th>
					<th>Terminal Name</th>
					<th>Contact Number</th>
					<th>PickUp/Drop</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${terminals}" var="terminal">
					<tr>
						<td><c:out value="${terminal.terminalid}" /></td>
						<td><c:out value="${terminal.terminalname}" /></td>
						<td><c:out value="${terminal.terminalcontact}" /></td>
						<td><a style="color: white" href="substations/${terminal.terminalname}"><i class="fa fa-terminal"></i></a></td>
						<td><a style="color: red" href="deleteterminal/${terminal.terminalid}" onclick="return confirm('Are you sure?')" ><i class="fa fa-trash"></i></a></td>
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