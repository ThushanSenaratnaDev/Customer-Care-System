<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="FAQ1.FAQ" %> 
<%@ page import="ViewFAQ.ViewFAQCustomerServlet" %>

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
    <title>View FAQs - Online Banking System</title>
    <link rel="stylesheet" type="text/css" href="CSS/ViewFAQ.css"/> <!-- Linking CSS -->
    <link rel="stylesheet" href="CSS/headerfooter.css">
    <script>
        // Function to toggle the visibility of the answer when a question is clicked
        function toggleAnswer(id) {
            var answer = document.getElementById(id);
            if (answer.style.display === "none" || answer.style.display === "") {
                answer.style.display = "block"; // Show the answer
            } else {
                answer.style.display = "none"; // Hide the answer
            }
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


 

 





    <div class="container">
       
        
        <!-- FAQs Section -->
        <div class="faq-section">
            <h2>Frequently Asked Questions</h2>
            <table class="faq-table">
                <tbody>
                    <%
                        int Counter = 1;
                        ArrayList<FAQ> allFAQ = (ArrayList<FAQ>) request.getAttribute("faqList");
                        if (allFAQ != null && !allFAQ.isEmpty()) {
                            for (FAQ faq : allFAQ) {
                    %>
                    <tr>
                        <td>
                            <a href="javascript:void(0);" onclick="toggleAnswer('answer<%= Counter %>')">
                                <%= Counter++ %>. <%= faq.getQuestion() %>
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td id="answer<%= Counter - 1 %>" class="answer">
                            <%= faq.getAnswer() %>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="5">No FAQs found.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>

       <!-- Inquiry Form Section -->
<div class="inquiry-section" id="inquiry-section">
    <h2 id="inquiry-header">Send an Inquiry</h2>
    <form action="SendInquiry" method="post" id="inquiry-form" onsubmit="return validateForm()"> <!-- POST method -->
        <input type="hidden" value="<%= cusID %>" name="CusID" id="cusID">
        
        <label for="category" id="category-label">Category:</label>
        <select id="category" name="category" >
            <option value="loan">Loan</option>
            <option value="account">Account</option>
            <option value="pawning">Pawning</option>
            <option value="cards">Cards</option>
        </select>

        <label for="inquiry" id="inquiry-label">Inquiry:</label>
        <textarea id="inquiry" name="inquiry" placeholder="Type your inquiry here..." ></textarea>
		<br><br>
        <button type="submit" class="submit-btn" id="submit-inquiry-btn">Submit Inquiry</button>
    </form>
</div>

<script>
function validateForm() {
    var inquiry = document.getElementById("inquiry").value.trim();
    
    if (inquiry === "") {
        alert("Inquiry section cannot be empty.");
        return false;
    }

    if (inquiry.length > 600) {
        alert("Inquiry cannot exceed 600 characters.");
        return false;
    }

    return true; // Form will submit if validation passes
}
</script>
    </div>

    <!-- Button to view previous inquiries -->
    <a href="inquiryServlet" > 
        <input type="button" class="YourInquiry" value="Your Inquiries"> 
    </a>
    
    
    
    
    
    
    
    
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
        <a href="FeedbackGet" class="feedback-button">Give Feedback</a>
    </footer>

    <!-- Link to FontAwesome for icons -->
    <script src="https://kit.fontawesome.com/10047d289b.js" crossorigin="anonymous"></script>
    
</body>
</html>