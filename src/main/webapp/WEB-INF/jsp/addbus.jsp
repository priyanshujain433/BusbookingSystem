<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Bus Details</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="https://kit.fontawesome.com/2c135d6bdb.js" crossorigin="anonymous"></script>
</head>
<body>
    <header>
       <img alt="logo" src="images/Logo.png" class="logo">
       <div class="signup"><a href="admin" ><i class="fa fa-home"></i></a></div>
    </header>
    
    <form class="middle-container" action="savebus.do" method="post">
        <h1 class="form-heading">Enter Bus Details Here</h1>
        <label for="busid">Bus ID :</label><br>
        <input type="number" name="busid" placeholder="Enter Bus Id" required id="bid">
        <label for="type">Type :</label><br>
        <select id="types" name="type">
            <option >Select Your Bus Type</option>
            <option >AC-Sleeper</option>
            <option >AC-Seater</option>
            <option >NON AC-Sleeper</option>
            <option >NON AC-Seater</option>
        </select>
        <label for="seats">Number of Seats :</label><br>
        <input type="number" name="seats" placeholder="Enter Number of Seats" required id="seats">
        <label for="regno">Registration No :</label><br>
        <input type="text" name="regno" placeholder="Enter Registration Number" required id="regno">
        <input class="reg-btn" type="submit" value="Add">
        <input class="reg-btn" type="reset"  value="Clear">
    </form>
    <footer>
        <small>© 2022 DXCTechnology.</small>
    </footer>
</body>
</html>