<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="Inquiries.InqModel" %>
<%@ page import="Inquiries.GetDataServlet" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Loan Inquiries</title>
    <link rel="stylesheet" href="CSS/LoanInq.css">
    <link rel="stylesheet" href="CSS/headerfooter.css">
    <style>
        .error-message {
            color: red;
            font-size: 0.9em;
            display: none;
        }
        .answer {
            margin-top: 5px;
            font-weight: bold;
        }
        .no-answer {
            margin-top: 5px;
            font-style: italic;
            color: grey;
        }
        .response-box {
            margin-top: 10px;
            display: none;
        }
        .char-count {
            margin-top: 5px;
            font-size: 0.9em;
            color: green;
        }
    </style>
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
                <a href="Inq.jsp" class="icon-button home-button" title="Home">
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
    <h2>Loan Inquiries</h2>

    <!-- Inquiry Questions -->
    <div class="questions-container">
        <%
            ArrayList<InqModel> inquiries = (ArrayList<InqModel>) request.getAttribute("InqList");

            if (inquiries != null) {
                for (InqModel inquiry : inquiries) {
                    int inquiryId = inquiry.getInID();
                    String inquiryText = inquiry.getInquiry();
                    int cusId = inquiry.getCusID(); 
                    String inquiryCat = inquiry.getCategory();
                    String IAnswer = inquiry.getIAnswer();  // This is the answer field
                    int InAnsID = inquiry.getInAnsID();
        %>
        
        <div class="inquiry-item">
            <!-- Display Inquiry -->
            <div class="question-box" onclick="showTextBox('response<%= inquiryId %>')">
                <%= inquiryText %>
            </div>

            <!-- Display the answer or "No answer" -->
            <div class="answer">
                <%= (IAnswer != null && !IAnswer.trim().isEmpty()) ? "Answer: " + IAnswer : "No answer" %>
            </div>

            <!-- Hidden Text Box for Responses -->
            <div id="response<%= inquiryId %>" class="response-box">
                <form action="InqInsertServlet" method="post" onsubmit="return validateForm(this)">
                    <input type="hidden" name="InID" value="<%= inquiryId %>">
                    <input type="hidden" name="InAnsID" value="<%= InAnsID %>">
                    
                    <!-- Pre-fill the textarea with answer if it exists -->
                    <textarea name="IAnswers" required oninput="updateCharCount(this, <%= inquiryId %>)" maxlength="500"><%= IAnswer != null ? IAnswer : "" %></textarea>
                    
                    <div class="error-message" id="error<%= inquiryId %>">Answer cannot be empty.</div>
                    <div id="charCount<%= inquiryId %>" class="char-count">500 characters remaining</div>
                    
                    <!-- 3 buttons: Insert/Send, Edit, Delete -->
                    <input type="submit" class="send-btn" value="Send" name="Send">
                    <input type="submit" class="edit-btn" value="Update" name="Send">
                    <input type="submit" class="delete-btn" value="Delete" name="Send">
                </form>
            </div>
        </div>

        <%
                }
            } else {
                out.println("<p>No inquiries available at the moment.</p>");
            }
        %>
    </div>

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

    <script>
        // Function to show/hide specific text boxes
        function showTextBox(id) {
            var textBox = document.getElementById(id);

            // Toggle visibility of the clicked text box
            if (textBox.style.display === 'none' || textBox.style.display === '') {
                textBox.style.display = 'block';
            } else {
                textBox.style.display = 'none';
            }
        }

        // Validation function with character limit
        function validateForm(form) {
            const textArea = form.IAnswers;
            const errorMessage = document.getElementById("error" + form.InID.value);
            
            // Clear previous error message
            errorMessage.style.display = 'none';

            // Check if the textarea is empty
            if (textArea.value.trim() === "") {
                errorMessage.innerText = "Answer cannot be empty.";
                errorMessage.style.display = 'block';
                return false; // Prevent form submission
            }

            // Check character limit (max 500 characters)
            if (textArea.value.length > 500) {
                errorMessage.innerText = "Answer exceeds the 500 character limit.";
                errorMessage.style.display = 'block';
                return false; // Prevent form submission
            }

            return true; // Allow form submission
        }

        // Function to update character count and display error if limit is exceeded
        function updateCharCount(textArea, inquiryId) {
            const charCount = document.getElementById("charCount" + inquiryId);
            const remainingChars = 500 - textArea.value.length;
            charCount.innerText = remainingChars + " characters remaining";

            if (remainingChars < 0) {
                charCount.style.color = 'red';
            } else {
                charCount.style.color = 'green';
            }
        }
        
      
    </script>

</body>
</html>