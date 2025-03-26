<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Search Routes Page</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="https://kit.fontawesome.com/2c135d6bdb.js" crossorigin="anonymous"></script>
</head>
<body>
    <header>
       <img alt="logo" src="images/Logo.png" class="logo">
       <div class="signup"><a href="home" ><i class="fa fa-home"></i></a></div>
    </header>
   <div class="middle-container">
    <form action="searchroute.do" method="get">
        <h1 class="form-heading">Search Routes Here</h1>
        <p id="login">${msg}</p>
        <label for="from">From :</label>
        <input type="text" name="from" placeholder="Enter Origin" required>
        <label for="to">To :</label><br>
        <input type="text" name="to" placeholder="Enter Destination" required>
        <label for="date">To :</label><br>
        <input type="date" name="date" placeholder="Enter Date of travel" required>
        <input class="btn" type="submit" value="Check Availability">
    </form>
    </div>
    <footer>
        <small>© 2022 DXCTechnology.</small>
    </footer>
</body>
</html>m