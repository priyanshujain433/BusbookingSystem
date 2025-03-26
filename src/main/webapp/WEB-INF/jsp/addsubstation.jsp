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
    
    <form class="middle-container" action="savesubstation" method="post">
        <h1 class="form-heading">Enter Sub-Station Details Here</h1>
        <p id="login">${emsg}</p>
        <p id="login" style="color: green">${msg}</p>
        <input type="hidden" value= "${terminal}" name = "terminal">
        <label for="substationid">Sub-Station ID :</label><br>
        <input type="number" name="substationid" placeholder="Enter Sub-Station Id" required id="substationid">
        <label for="substationname">Sub-Station Name :</label><br>
        <input type="text" name="substationname" placeholder="Enter Sub-Station Name" required id="substationname">
        <label for="substationcontact">Sub-Station Contact No :</label><br>
        <input type="number" name="substationcontact" placeholder="Sub-Station Contact No" required id="substationcontact">
        <input class="reg-btn" type="submit" value="Add">
        <input class="reg-btn" type="reset"  value="Clear">
    </form>
    <footer>
        <small>© 2022 DXCTechnology.</small>
    </footer>
</body>
</html>