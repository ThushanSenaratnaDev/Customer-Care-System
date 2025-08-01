<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ Submission Form</title>
<link rel="stylesheet" href="CSS/FAQ_Update.css">
 <link rel="stylesheet" href="CSS/headerfooter.css">
<script>
    function validateCharacterLimit(input, maxLength) {
        if (input.value.length > maxLength) {
            input.value = input.value.substring(0, maxLength); // Trim the input to the max length
            alert("Maximum " + maxLength + " characters allowed.");
        }
        document.getElementById(input.id + "-char-count").textContent = input.value.length + "/" + maxLength; // Update character count
    }
</script>
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


<br><br><br><br>

    <div class="form-container">
        <form action="AddFAQ" method="POST" >
            <h2>Submit a FAQ</h2>
            
            <label for="question">Question</label>
            <input type="text" id="question" name="question" required oninput="validateCharacterLimit(this, 300)">
            <small id="question-char-count">0/300</small> <!-- Display character count -->
            
            <label for="answer">Answer</label>
            <textarea id="answer" name="answer" rows="4" required oninput="validateCharacterLimit(this, 300)"></textarea>
            <small id="answer-char-count">0/300</small> <!-- Display character count -->
            <br>
            <input type="submit" value="Submit">
        </form>
        <input type="button" value="Go to FAQ List" onclick="location.href='AllFAQServlet'">
    </div>
    
    
    
    <br><br><br><br><br><br><br>
    
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
        
    </footer>

    <!-- Link to FontAwesome for icons -->
    <script src="https://kit.fontawesome.com/10047d289b.js" crossorigin="anonymous"></script>
    
</body>
</html>