<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Inquiries</title>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Inquiries</title>
    <link rel="stylesheet" href="CSS/Inq.css">
    <link rel="stylesheet" href="CSS/headerfooter.css">
</head>
<body>

	 <!-- header -->
     <header>
    <div class="header-container">
        <div class="logo">
            <img src="CSS/tmklogo.png" alt="OBC Bank Logo">
        </div>
        <h1>TMK Bank Customer Care System</h1>
        <div class="icons">
            <a href="EmployeeHome.jsp" class="icon-button home-button" title="Home">
                <i class="fas fa-home"></i>
            </a>
            <a href="profile.html" class="icon-button profile-button" title="User Name">
                <i class="fas fa-user"></i>
            </a>
            <a href="EmployeeLogin.jsp" class="logout-button">Log Out</a>
        </div>
    </div>
</header>

    <!-- Page Title -->
    <h2>Customer Inquiries</h2><br><br><br>

    <!-- Inquiry Boxes -->
<div class="inquiry-container">
    <div>
    <div class="inquiry-box" onclick="location.href='GetDataServlet?inquiryType=loan'">Loan Inquiries</div>
    <br><br><br><br>
    <div class="inquiry-box" onclick="location.href='GetDataServlet?inquiryType=card'">Card Inquiries</div>
    </div>
    <br><br><br>
    <div>
    <div class="inquiry-box" onclick="location.href='GetDataServlet?inquiryType=account'">Account Inquiries</div>
     <br><br><br><br>
    <div class="inquiry-box" onclick="location.href='GetDataServlet?inquiryType=pawn'">Pawn Inquiries</div>
    </div>
</div>
<br><br><br><br><br><br><br><br><br>
    <!-- Footer -->
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
        
    </footer>

    <!-- Link to FontAwesome for icons -->
    <script src="https://kit.fontawesome.com/10047d289b.js" crossorigin="anonymous"></script>
    
    
</body>
</html>