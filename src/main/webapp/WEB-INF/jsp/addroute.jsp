<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title>Destinations</title>
<link rel="stylesheet" href="css/style.css">
<script src="https://kit.fontawesome.com/2c135d6bdb.js"
	crossorigin="anonymous"></script>	
 <s:url var="url_jqlib" value="/js/jquery-3.6.0.min.js" />
<script src="${url_jqlib}"> </script>
<script>
	
$(document).ready(function(){
	$('#businfo').change(function(){
		var busid =$(this).val();
		$.ajax({
			type:'GET',
			url:'loadbusinfo/'+busid,
			success:function(result){
				var result1 = JSON.parse(result);
				var r ='';
				var t ='';
				var s ='';
				console.log(result.length);
				console.log(result1.length);
				console.log(result1.regno);
					r+='<option>'+result1.regno+'</option>';
					t+='<option>'+result1.type+'</option>';
					s+='<option>'+result1.seats+'</option>';
				$('#regno').html(r);
				$('#types').html(t);
				$('#seats').html(s);
			}
		});
	});
});
	
</script>	
</head>
<body>
	<header>
		<img alt="logo" src="images/Logo.png" class="logo">
		<div class="signup">
			<a href="admin"><i class="fa fa-home"></i></a>
		</div>
	</header>

	<form class="middle-container route-container" action="saveroute.do" method="post">
		<h1 class="form-heading route-heading">Enter Route Details Here</h1>
		<label for="busid">Bus ID :</label><br> <select id="businfo"
			name="busid">
			<option>Select Bus ID</option>
			<c:forEach items="${buses}" var="bus">
				<option><c:out value="${bus.busid}" /></option>
			</c:forEach>
		</select> 
		<label for="regno">Registration No :</label><br> 
		<select id="regno" name="regno"></select>
		<label for="bustype">Bus Type :</label><br>   
		<select id="types" name="type"></select>
		<label for="type">From :</label><br> 
		<select id="from" name="origin">
			<option>Select origin</option>
			<c:forEach items="${terminals}" var="terminal">
				<option><c:out value="${terminal.terminalname}" /></option>
			</c:forEach>
		</select> 
		<label for="to">To :</label><br> <select id="from" name="destination">
			<option>Select destination</option>
			<c:forEach items="${terminals}" var="terminal">
				<option><c:out value="${terminal.terminalname}" /></option>
			</c:forEach>
		</select> 
		<label for="seats">No of seats :</label><br> 
		<select id="seats" name="seats"></select> 
		 <label for="dateoftravel">Enter Travel Date :</label><br> 
		 <input type="date" name="dateoftravel" placeholder="Enter travel date " required> 
		 <label for="departuretime">Enter Departure Time :</label><br> 
		 <input type="time" name="departuretime" placeholder="Enter departure time " required>
		 <label for="departuretime">Enter Arrival Time :</label><br> 
		 <input type="time" name="arrivaltime" placeholder="Enter arrival time " required>
		 <label for="fare">Enter Ticket Fare :</label><br> 
		 <input type="number" name="fare" placeholder="Enter Ticket Fare " required> 
		 <input class="reg-btn" type="submit" value="Add"> 
		 <input class="reg-btn" type="reset" value="Clear">
	</form>
	<footer>
		<small>© 2022 DXCTechnology.</small>
	</footer>
</body>
</html>