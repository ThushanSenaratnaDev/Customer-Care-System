<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import="java.util.ArrayList" %>
<%@ page import="FAQ1.FAQ" %> 
<%@ page import="FAQ1.AllFAQServlet" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Manage FAQs</title>
<link rel="stylesheet" type="text/css" href="CSS/AllFAQ.css">
<link rel="stylesheet" href="CSS/headerfooter.css">
</head>
<body>


<!-- Header -->
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









   <div class='FAQ_table'>
   <h1>FAQ Manager</h1>
    <table  class="faq-table">
        <thead>
            <tr>
                <th>FAQ ID</th>
                <th>Question</th>
                <th>Answer</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
        <%
            ArrayList<FAQ> allFAQ = (ArrayList<FAQ>) request.getAttribute("faqList");
            if (allFAQ != null && !allFAQ.isEmpty()) {
                for (FAQ faq : allFAQ) {
        %>
        <tr>
            <form action="ChangeFAQ.jsp" method="post">
                <td><%= faq.getFAQID() %></td>
                <td><%= faq.getQuestion() %></td>
                <td><%= faq.getAnswer() %></td>
                
                
                <!-- Hidden fields to pass the FAQ data -->
                <input type="hidden" name="faqID" value="<%= faq.getFAQID() %>">
                <input type="hidden" name="question" value="<%= faq.getQuestion() %>">
                <input type="hidden" name="answer" value="<%= faq.getAnswer() %>">
                <td><button type="submit" class="update-btn">Update</button></td>
            </form>
            
            <!-- Hidden form to pass FAQID for delete function -->
            <form action="DeleteFAQServlet" method="post">
                <input type="hidden" name="faqID" value="<%= faq.getFAQID() %>">
                <td><button type="submit" class="delete-btn">Delete</button></td>
            </form>
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
    <a href="FAQ_Update.jsp">
        <input class="redirect-btn" type="button" name="Add_Question" value="Add Question">
    </a>
    
    </div>
    
    <br><br><br>
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