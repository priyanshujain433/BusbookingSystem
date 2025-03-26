<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Bus Booking</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/home-styles.css">
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;900&family=Ubuntu:wght@300&display=swap"
	rel="stylesheet">
<!-- Fontawesome Icons -->
<script src="https://kit.fontawesome.com/2c135d6bdb.js"
	crossorigin="anonymous"></script>
</head>

<body>

	<section id="title">

		<!-- Nav Bar -->
		<div class="container-fluid">
			<nav class="navbar navbar-expand-lg navbar-dark">
				<img alt="logo" src="images/Logo.png" class="logo">
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="busdetail">Bus <i class="fas fa-bus"></i></a>
						</li>
                        <li class="nav-item"><a class="nav-link" href="terminal">Terminals <i class="fas fa-stop-circle"></i></a>
						</li>
						<li class="nav-item"><a class="nav-link" href="route">Routes <i class="fas fa-route"></i></a>
						</li>
						<li class="nav-item"><a class="nav-link" href="tickets">Bookings <i class="fas fa-ticket-alt"></i></a>
						</li>
						<li class="nav-item"><a class="nav-link" href="signout.do"><i
								class="fas fa-sign-out-alt"></i></a></li>
					</ul>
				</div>
			</nav>
			<!-- Title -->
			<div class="row">
				<div class="col-lg-5">
					<div class="head1">
						<h1 class="big-heading">
							<q>People don't take trips, trips take people.</q>
						</h1>
					</div>
				</div>
				<div class="col-lg-7">
					<img alt="bus" src="/images/bus.png" class="bus">
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Footer -->
	<footer id="footer">
		<i class="social-icons fab fa-twitter"></i> <i
			class="social-icons fab fa-facebook"></i> <i
			class="social-icons fab fa-instagram"></i> <i
			class="social-icons fas fa-envelope"></i>
		<p>© Copyright 2022 DXCTechnology</p>

	</footer>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>

</html>
