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
</head>
<body class="the_wall ticket">
    <a href="home" class="home"><i class="fa fa-home"></i></a>
   							 <form action="saveticket" method="post">
                                <div class="card-block ticket-block">
                                    <h6 class="m-b-20 p-b-5 b-b-default f-w-600">Ticket Information</h6>
                                    <div class="row">
                                        <div class="col-sm-8">
                                            <p class="m-b-10 f-w-600">From</p>
                                            <input type="hidden" name=userid value="${user.email}">
                                            <input type="hidden" name=origin value="${route.origin}">
                                            <h6 class="text-muted f-w-400">${route.origin}</h6>
                                        </div>
                                        <div class="col-sm-4">
                                            <p class="m-b-10 f-w-600">To</p>
                                            <input type="hidden" name=destination value="${route.destination}">
                                            <h6 class="text-muted f-w-400">${route.destination}</h6>
                                        </div>
                                         <div class="col-sm-8">
                                            <p class="m-b-10 f-w-600">Bus Type</p>
                                            <input type="hidden" name=type value="${route.type}">
                                            <h6 class="text-muted f-w-400">${route.type}</h6>
                                        </div>
                                        <div class="col-sm-4">
                                            <p class="m-b-10 f-w-600">Vehicle Number</p>
                                            <input type="hidden" name=regno value="${route.regno}">
                                            <h6 class="text-muted f-w-400">${route.regno}</h6>
                                        </div>
                                        <div class="col-sm-8">
                                            <p class="m-b-10 f-w-600">Departure Date </p>
                                            <input type="hidden" name=date value="${route.dateoftravel}">
                                            <h6 class="text-muted f-w-400">${route.dateoftravel}</h6>
                                        </div>
                                        <div class="col-sm-4">
                                            <p class="m-b-10 f-w-600">Departure Time</p>
                                            <input type="hidden" name=dtime value="${route.departuretime}">
                                            <h6 class="text-muted f-w-400">${route.departuretime}</h6>
                                        </div>
                                        <div class="col-sm-8">
                                            <p class="m-b-10 f-w-600">Pickup point </p>
                                            <input type="hidden" name=pickuppoint value="${passanger.pickup}">
                                            <h6 class="text-muted f-w-400">${passanger.pickup}</h6>
                                        </div>
                                        <div class="col-sm-4">
                                            <p class="m-b-10 f-w-600">Drop point</p>
                                            <input type="hidden" name=droppoint value="${passanger.drop}">
                                            <h6 class="text-muted f-w-400">${passanger.drop}</h6>
                                        </div>
                                    </div>
                                    <h6 class="m-b-20 m-t-40 p-b-5 b-b-default f-w-600">Passenger Details</h6>
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <p class="m-b-10 f-w-600"></p>
                                            <input type="hidden" name=pname1 value="${passanger.passangerName1}">
                                            <h6 class="text-muted f-w-400">${passanger.passangerName1}</h6>
                                            <p class="m-b-10 f-w-600"></p>
                                            <input type="hidden" name=pnum1 value="${passanger.passangernumber1}">
                                            <h6 class="text-muted f-w-400">${passanger.passangernumber1}</h6>
                                        </div>
                                        <div class="col-sm-4">
                                             <p class="m-b-10 f-w-600"></p>
                                             <input type="hidden" name=pname2 value="${passanger.passangerName2}">
                                            <h6 class="text-muted f-w-400">${passanger.passangerName2}</h6>
                                              <p class="m-b-10 f-w-600"></p>
                                              <input type="hidden" name=pnum2 value="${passanger.passangernumber2}">
                                            <h6 class="text-muted f-w-400">${passanger.passangernumber2}</h6>
                                        </div>
                                        <div class="col-sm-4">
                                            <p class="m-b-10 f-w-600"></p>
                                            <input type="hidden" name=pname3 value="${passanger.passangerName3}">
                                           <h6 class="text-muted f-w-400">${passanger.passangerName3}</h6>
                                             <p class="m-b-10 f-w-600"></p>
                                             <input type="hidden" name=pnum3 value="${passanger.passangernumber3}">
                                           <h6 class="text-muted f-w-400">${passanger.passangernumber3}</h6>
                                       </div>
                                    </div>
                                    <h6 class="m-b-20 m-t-40 p-b-5 b-b-default f-w-600">Fare Details</h6>
                                    <div class="row">
                                        <div class="col-sm-8">
                                            <p class="m-b-10 f-w-600">Fare</p>
                                        </div>
                                        <div class="col-sm-4">
                                       		<input type="hidden" name=totalfare value="${passanger.totalfare}">
                                            <p class="m-b-10 f-w-600">Rs.${passanger.totalfare}</p>
                                            <input type="hidden" name=tickettime value="<%= (new java.util.Date()).toString()%>">
                                        </div>
                                        <input type="submit" class="btn btn-primary btn-md active cnfbtn" value="Confirm">
                                    </div>
                                </div>
							</form>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script> 
</body>
</html>