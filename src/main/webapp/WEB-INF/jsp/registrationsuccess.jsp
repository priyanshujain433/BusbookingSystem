<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registrtion Success</title>
    <link rel="stylesheet" href="css/style.css">
    <script src="https://kit.fontawesome.com/2c135d6bdb.js" crossorigin="anonymous"></script>
</head>
<body>
    <header>
       <img alt="logo" src="images/Logo.png" class="logo">
       <div class="signup"><a href="signin"><i class="fas fa-sign-in-alt"></i></a></div>
    </header>
   <div class="middle-container">
    <form>
        <h1 class="form-heading">Success!</h1><br>
        <p style="margin-left: 40px"> Hi! ${firstname} ${lastname}, Your account has been created.</p><br>
        <a style="text-decoration: none; align-items: center; padding: 10px 75px 10px 75px; margin-left: 75px" class="btn" href="signin">Login</a>
    </form>
    </div>
    <footer>
        <small>� 2022 DXCTechnology.</small>
    </footer>
</body>
</html>