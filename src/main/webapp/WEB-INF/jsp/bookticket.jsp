<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>Bus Ticket</title>
<link rel="stylesheet" href="css/style.css">
<s:url var="url_jqlib" value="/js/passanger.js" />
<script src="https://kit.fontawesome.com/2c135d6bdb.js" crossorigin="anonymous"></script>
<script type="text/javascript">
function passanger() {
    var p = document.getElementById("ticketcount").value;
    var a = document.getElementById("passanger1name");
    var c = document.getElementById("passanger2name");
    var e = document.getElementById("passanger3name");
    var b = document.getElementById("passanger1number");
    var d = document.getElementById("passanger2number");
    var f = document.getElementById("passanger3number");
    var r = document.getElementById("fare").value;
    var s = document.getElementById("totalfare");
    var btn = document.getElementById("btn");
    var n = document.getElementById("label");
    console.log(s);
    if (p==1) {
    	var t1 = p*r;
    	console.log(t1);
    	s.value = t1;
    	btn.style.display = "block";
    	n.style.display = "block";
    	a.required = true;
    	a.style.display = "block";
        b.style.display = "block";
        b.required = true;
        c.style.display = "none";
        d.style.display = "none";
        e.style.display = "none";
        f.style.display = "none";
    } else if(p==2) {
    	var t3 = p*r;
    	s.value = t3;
    	n.style.display = "block";
    	btn.style.display = "block";
    	b.required = true;
    	a.style.display = "block";
    	b.required = true;
        b.style.display = "block";
        c.required = true;
        c.style.display = "block";
        d.required = true;
        d.style.display = "block";
        e.style.display = "none";
        f.style.display = "none";
    }else if(p==3){
    	var t3 = p*r;
    	s.value = t3;
    	n.style.display = "block";
    	btn.style.display = "block";
    	b.required = true;
    	a.style.display = "block";
    	b.required = true;
        b.style.display = "block";
        c.required = true;
        c.style.display = "block";
        d.required = true;
        d.style.display = "block";
        e.required = true;
        e.style.display = "none";
        f.required = true;
        f.style.display = "none";
    }
    else{
		n.style.display = "none";
    	btn.style.display = "none";
    	a.style.display = "none";
        b.style.display = "none";
        c.style.display = "none";
        d.style.display = "none";
        e.style.display = "none";
        f.style.display = "none";
        
    }
}
</script>
</head>
<body>
	<header>
		<img alt="logo" src="images/Logo.png" class="logo">
		<div class="signup">
			<a href="home"><i class="fa fa-home"></i></a>
		</div>
	</header>
	<div class="middle-container">
		<form class="bookticket" action="bookticket" method="post">
			<h1 class="form-heading">Bus Ticket</h1>
			<p id="login"></p>
			<input type="hidden" value="${fare}" id="fare"> <label
				for="pickup">Pickup point :</label> 
				<select id="pickup" name="pickup" required>
					<option></option>
					<c:forEach items="${pickup}" var="pickup">
					<option><c:out value="${pickup.substationname}" /></option>
				</c:forEach>
				</select> 
				<label for="pickup">Drop point :</label> 
				<select id="drop" name="drop" required>
					<option></option>
					<c:forEach items="${drop}" var="drop">
					<option><c:out value="${drop.substationname}" /></option>
					</c:forEach>
				</select>
			<label for="noOfTckets">Enter Number of Tickets :</label> 
			<input type="number" name="ticketcount" placeholder="Enter Number of Tickets" required min="1" max="3" id="ticketcount" oninput="passanger()">
			<label for="pickup" id= "label">Enter Passanger Details :</label>
			<input type="text" name="passangerName1" placeholder="Enter Passanger 1 Name" id="passanger1name" >
			<input type="tel" name="passangernumber1" placeholder="Enter Passanger 1 Number" id="passanger1number" >
			<input type="text" name="passangerName2" placeholder="Enter Passanger 2 Name" id="passanger2name" >
			<input type="tel" name="passangernumber2" placeholder="Enter Passanger 2 Number" id="passanger2number" >
			<input type="text" name="passangerName3" placeholder="Enter Passanger 3 Name" id="passanger3name" >
			<input type="tel" name="passangernumber3" placeholder="Enter Passanger 3 Number" id="passanger3number">
			<input type="hidden" name=totalfare id="totalfare" value="">
			<input type="submit" class="btn" value="Bookticket" id="btn">
		</form>
	</div>
	<footer>
		<small>© 2022 .Gavirangaswamy</small>
	</footer>
</body>
</html>