<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Terminal Details</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="https://kit.fontawesome.com/2c135d6bdb.js" crossorigin="anonymous"></script>
</head>
<body>
    <header>
       <img alt="logo" src="images/Logo.png" class="logo">
       <div class="signup"><a href="admin" ><i class="fa fa-home"></i></a></div>
    </header>
    
    <form class="middle-container" action="saveterminal.do" method="post">
        <h1 class="form-heading">Enter Terminal Details</h1>
        <label for="terminalid">Terminal ID :</label><br>
        <input type="number" name="terminalid" placeholder="Enter Terminal Id" required id="tid">
        <label for="tname">Terminal Name :</label><br>
        <input type="text" name="terminalname" placeholder="Enter Terminal Name" required id="tname">
        <label for="tcontact">Contact No :</label><br>
        <input type="tel" name="terminalcontact" placeholder="Enter Contact Number" required id="tcontact">
        <input class="reg-btn" type="submit" onclick="regValidation()" value="Add">
        <input class="reg-btn" type="reset"  value="Clear">
    </form>
    <footer>
        <small>© 2022 DXCTechnology.</small>
    </footer>
</body>
</html>