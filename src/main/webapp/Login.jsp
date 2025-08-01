<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Login</title>
    <link rel="stylesheet" href="CSS/Login.css">
    <link rel="stylesheet" href="CSS/headerfooter.css">

</head>
<body>


    <!-- Header Section -->
    <header>
    <div class="header-container">
        <div class="logo">
             <img src="CSS/tmklogo.png" alt="OBC Bank Logo">
        </div>
        <h1>TMK Bank Customer Care System</h1>
        <div class="icons">
            <!-- <a href="home.html" class="icon-button home-button" title="Home">
                <i class="fas fa-home"></i>
            </a>
            <a href="profile.html" class="icon-button profile-button" title="User Name">
                <i class="fas fa-user"></i>
            </a> -->
            <a href="EmployeeLogin.jsp" class="logout-button">Employee Login</a>
        </div>
    </div>
</header>







 <div class="login-container">
        <h2>Login</h2>
        
         <!-- Error message section (initially hidden) -->
        <p id="error-message" class="error-message" style="display:none;"></p>
        
        
        <form action="CusLoginServlet" method="post" class="form">
            <div class="input-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="input-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit" class="submit-btn">Login</button>
        </form>
    </div>
    
   

    <!-- JavaScript to display the error message -->
    <script>
        // Pass the error message from the server as a JavaScript variable
        var loginError = "<%= request.getAttribute("loginError") != null ? request.getAttribute("loginError") : "" %>";

        // If there is an error message, display it
        if (loginError) {
            var errorMessageElement = document.getElementById("error-message");
            errorMessageElement.textContent = loginError;
            errorMessageElement.style.display = "block"; // Make the error message visible
        }
    </script>
    
   <br><br> <br><br>
    
     <!-- Footer Section -->
    <footer>
        <div class="contact-info">
            <p>Contact us : 0112345656</p>
            <p>Email: <a href="mailto:tmkbankcustomercare@gmail.com">tmkbankcustomercare@gmail.com</a></p>
        </div>
        <div class="social-media">
            <button class="b_social" onclick="window.location ='https://www.instagram.com/'"><i class="fa-brands fa-instagram"></i></button>
                <button class="b_social" onclick="window.location ='https://www.facebook.com/'"><i class="fa-brands fa-square-facebook"></i></button>
                <button class="b_social" onclick="window.location ='https://www.messenger.com/'"><i class="fa-brands fa-facebook-messenger"></i></button>
               

            
        </div>
       <!--  <a href="feedback.html" class="feedback-button">Give Feedback</a> -->
    </footer>

    <!-- Link to FontAwesome for icons -->
    <script src="https://kit.fontawesome.com/10047d289b.js" crossorigin="anonymous"></script>
    

</body>
</html>