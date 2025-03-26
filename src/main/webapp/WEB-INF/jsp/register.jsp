<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
    <title>Signup Page</title>
    <link rel="stylesheet" href="css/style.css">
    <s:url var="url_jqlib" value="/js/main.js" />
    <script src="https://kit.fontawesome.com/2c135d6bdb.js" crossorigin="anonymous"></script>
</head>
<body>
    <header>
       <img alt="logo" src="images/Logo.png" class="logo">
       <div class="signup"><a href="signin" ><i class="fas fa-sign-in-alt"></i></a></div>
    </header>
    
    <form class="middle-container" action="save.do" method="post">
        <h1 class="form-heading">Register Here</h1>
        <p id="message"></p>
        <label for="firstname">Firstname :</label><br>
        <input type="text" name="firstName" placeholder="Enter your Firstname" required id="fName">
        <label for="lastname">Lastname :</label><br>
        <input type="text" name="lastName" placeholder="Enter your Lastname" required id="lName">
        <label for="lastname">City :</label><br>
        <input type="text" name="city" placeholder="Enter your city" required id="city">
        <label for="email">Email :</label><br>
        <input type="email" name="email" placeholder="Enter your email" id="email" required>
        <label for="phone">Mobile Number :</label><br>
        <input type="tel" name="mobile" placeholder="Enter your Mobile Number" id="phone" required>
        <label for="password">Password :</label><br>
        <input type="password" placeholder="Enter your Password" id="pass" name="password" required>
        <p id="pmsg">Password is <span id="strength"></span></p>
        <label for="cnfpassword">Confirm Password :</label>
        <input type="password" placeholder="Enter your Password" id="cnfpassword" name="confirmPassword" required>
        <input class="reg-btn" type="submit" value="Register">
        <input class="reg-btn" type="reset"  value="Clear">
    </form>
    <footer>
        <small>© 2022 DXCTechnology.</small>
    </footer>
    <script type="text/javascript" src="js/main.js"></script>
</body>
</html>