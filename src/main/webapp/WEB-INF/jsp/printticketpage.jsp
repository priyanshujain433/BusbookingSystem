<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="java.util.*" %>   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/profile-style.css"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/2c135d6bdb.js" crossorigin="anonymous"></script>
    <title>Ticket</title>
    <script type="text/javascript">
    	function hide(){
    		 var h = document.getElementById("home");
    		 var b = document.getElementById("btn");
    		 h.style.display = "none";
    		 b.style.display = "none";
    	}
    </script>
</head>
<body class="the_wall ticket">
    <a href="home" class="home" id="home"><i class="fa fa-home"></i></a>
   							 <form action="saveticket" method="post">
                                <div class="card-block ticket-block">
                                    <h6 class="m-b-20 p-b-5 b-b-default f-w-600">Ticket Information</h6>
                                      <div class="row">
                                        <div class="col-sm-8">
                                            <p class="m-b-10 f-w-600">Ticket Number</p>
                                            <p class="m-b-10 f-w-600">${userticket.ticketid}</p>
                                        </div>
                                        <div class="col-sm-4">
                                        	<p class="m-b-10 f-w-600">Ticket Generated Time</p>
                                            <p class="m-b-10 f-w-600">Rs.${userticket.tickettime}</p>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-8">
                                            <p class="m-b-10 f-w-600">From</p>
                                            <h6 class="text-muted f-w-400">${userticket.origin}</h6>
                                        </div>
                                        <div class="col-sm-4">
                                            <p class="m-b-10 f-w-600">To</p>
                                            <h6 class="text-muted f-w-400">${userticket.destination}</h6>
                                        </div>
                                         <div class="col-sm-8">
                                            <p class="m-b-10 f-w-600">Bus Type</p>
                                            <h6 class="text-muted f-w-400">${userticket.type}</h6>
                                        </div>
                                        <div class="col-sm-4">
                                            <p class="m-b-10 f-w-600">Vehicle Number</p>
                                            <h6 class="text-muted f-w-400">${userticket.regno}</h6>
                                        </div>
                                        <div class="col-sm-8">
                                            <p class="m-b-10 f-w-600">Departure Date </p>
                                            <h6 class="text-muted f-w-400">${userticket.date}</h6>
                                        </div>
                                        <div class="col-sm-4">
                                            <p class="m-b-10 f-w-600">Departure Time</p>
                                            <h6 class="text-muted f-w-400">${userticket.dtime}</h6>
                                        </div>
                                        <div class="col-sm-8">
                                            <p class="m-b-10 f-w-600">Pickup point </p>
                                            <h6 class="text-muted f-w-400">${userticket.pickuppoint}</h6>
                                        </div>
                                        <div class="col-sm-4">
                                            <p class="m-b-10 f-w-600">Drop point</p>
                                            <h6 class="text-muted f-w-400">${userticket.droppoint}</h6>
                                        </div>
                                    </div>
                                    <h6 class="m-b-20 m-t-40 p-b-5 b-b-default f-w-600">Passenger Details</h6>
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <p class="m-b-10 f-w-600"></p>
                                            <h6 class="text-muted f-w-400">${userticket.pname1}</h6>
                                            <p class="m-b-10 f-w-600"></p>
                                            <h6 class="text-muted f-w-400">${userticket.pnum1}</h6>
                                        </div>
                                        <div class="col-sm-4">
                                             <p class="m-b-10 f-w-600"></p>
                                            <h6 class="text-muted f-w-400">${userticket.pname2}</h6>
                                              <p class="m-b-10 f-w-600"></p>
                                            <h6 class="text-muted f-w-400">${userticket.pnum2}</h6>
                                        </div>
                                        <div class="col-sm-4">
                                            <p class="m-b-10 f-w-600"></p>
                                           <h6 class="text-muted f-w-400">${userticket.pname3}</h6>
                                             <p class="m-b-10 f-w-600"></p>
                                           <h6 class="text-muted f-w-400">${userticket.pnum3}</h6>
                                       </div>
                                    </div>
                                    <h6 class="m-b-20 m-t-40 p-b-5 b-b-default f-w-600">Fare Details</h6>
                                    <div class="row">
                                        <div class="col-sm-6">
                                            <p class="m-b-10 f-w-600">Fare</p>
                                            <p class="m-b-10 f-w-600">Rs.${userticket.totalfare}</p>
                                        </div>
                                        <div class="col-sm-6">
                                        <input type="submit" class="btn btn-primary btn-md active cnfbtn" value="Print" onclick="hide(); window.print();" id="btn">
                                        </div>
                                    </div>
                                </div>
							</form>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script> 
</body>
</html>