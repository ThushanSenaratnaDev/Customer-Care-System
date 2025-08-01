<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ViewFAQ.Inquiry" %>




<% 
	
    HttpSession session1 = request.getSession(false);  // Get the current session without creating a new one
    int cusID = -1;
    if (session1 != null && session1.getAttribute("cusID") != null) {
        cusID = (int) session1.getAttribute("cusID");
        String userName = (String) session1.getAttribute("username");  // Optional: Retrieve username if stored
    } else {
        // Redirect to login page if session is invalid or does not exist
        response.sendRedirect("Login.jsp");
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Manage Inquiries</title>
    
    <!-- Link to the external CSS file -->
    <link rel="stylesheet" type="text/css" href="CSS/inquiry.css">
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
            <a href="ViewFAQCustomerServlet" class="icon-button home-button" title="Home">
                <i class="fas fa-home"></i>
            </a>
            <a href="profile.html" class="icon-button profile-button" title="User Name">
                <i class="fas fa-user"></i>
            </a>
            <a href="Logout" class="logout-button">Log Out</a>
        </div>
    </div>
</header>







<div class="Everything">

<br><br>
    <h2>Manage Your Inquiries</h2>
    
      <!-- Display the JavaScript popup if a message is set -->
    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
        <script>
            alert("<%= message %>");
        </script>
    <%
        }
    %>

    <%
        ArrayList<Inquiry> inquiries = (ArrayList<Inquiry>) request.getAttribute("inquiryList");
        if (inquiries != null && !inquiries.isEmpty()) {
            for (Inquiry inq : inquiries) {
    %>
    <div class="inquiry-card">
        <h3>Inquiry ID: <%= inq.getInId() %></h3>

        <div class="inquiry-info">
            <label>Category:</label>
            <p><%= inq.getCategory() %></p>
        </div>

        <div class="inquiry-info">
            <label>Your Inquiry:</label>
            <p><%= inq.getInquiry() %></p>
        </div>

        <div class="inquiry-info">
            <label>Answer:</label>
            <p><%= inq.getAnswer() != null ? inq.getAnswer() : "No answer yet" %></p>
        </div>

        <!-- Form for updating the inquiry -->
        <form action="updateInquiryServlet" method="post" class="inquiry-actions">
            <div>
                <label>Update Category:</label>
                <select name="category">
                    <option value="Loan" <%= inq.getCategory().equals("loan") ? "selected" : "" %>>Loan</option>
                    <option value="Account" <%= inq.getCategory().equals("account") ? "selected" : "" %>>Account</option>
                    <option value="Pawning" <%= inq.getCategory().equals("pawning") ? "selected" : "" %>>Pawning</option>
                    <option value="Cards" <%= inq.getCategory().equals("cards") ? "selected" : "" %>>Cards</option>
                </select>

                <label>Update Inquiry:</label>
                <textarea name="newInquiry"><%= inq.getInquiry() %></textarea>

                <!-- Hidden fields to pass inquiry data -->
                <input type="hidden" name="inquiryId" value="<%= inq.getInId() %>">
            </div>
            
            <br>
            <div class="Button-Container"></div>
                <button type="submit" class="update-btn">Update Inquiry</button>
            
        </form>

        <!-- Form for deleting the inquiry -->
        <form action="deleteServlet" method="post">
            <input type="hidden" name="inquiryId" value="<%= inq.getInId() %>">
            <button type="submit" class="delete-btn">Delete Inquiry</button>
        </form>
        </div>
    </div>
    <%
            }
        } else {
    %>
    <p>No Inquiries found.</p>
    <%
        }
    %>


</div>
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
        <a href="FeedbackGet" class="feedback-button">Give Feedback</a>
    </footer>

    <!-- Link to FontAwesome for icons -->
    <script src="https://kit.fontawesome.com/10047d289b.js" crossorigin="anonymous"></script>







</body>
</html>