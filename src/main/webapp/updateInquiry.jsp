<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Update Inquiry</title>
    <link rel="stylesheet" type="text/css" href="update.css">
    
</head>
<body>
	
<%
	String inID = request.getParameter("inID");
	String category = request.getParameter("category");
	String inquiry = request.getParameter("inquiry");
	String answer = request.getParameter("answer");
%>
<div class= "update_inquiry_container">
    <h2>Update Inquiry</h2>
    <form action="updateInquiryServlet" method="post" class="inquiry_form">
    
        <input type="hidden" name="inID" value ="<%=inID %>"><br><br>

     	<div class="form_group"><label for="category">Inquiry Category:</label>
        <select id="category" name="category" value ="<%=category %>" class="form_control">
            <option value="loan">Loan</option>
            <option value="account">Account</option>
            <option value="pawning">Pawning</option>
            <option value="cards">Cards</option>
        </select><br><br>
        </div>
        
		<div class="form_group">
        <label for="inquiry">Updated Inquiry:</label>
        <textarea id="inquiry" name="inquiry" value = "<%=inquiry %>"></textarea><br><br>
		</div>
		
		<div class="form_group">
        <label for="answer">Answer:</label>
        <textarea id="answer" name="answer" value = "<%=answer %>"></textarea><br><br>
		</div>
		
        <button type="submit" value="Update Inquiry"></button>
        
    </form>
</div>
</body>
</html>
