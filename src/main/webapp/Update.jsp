<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>

<%
	String InAnsID = request.getParameter("InAnsID"); 
	String InID = request.getParameter("InID");
	String IAnswers = request.getParameter("IAnswers");
%>

<form action="InqUpdateServlet" method="post">
	
	<table>
		<tr>
			<th>InAnsID</th>
			<td><input type="text" name="InAnsID" value="<%=InAnsID %>" readonly></td>
		</tr>
		
		<tr>
	        <th>InID</th>
	        <td><input type="text" name="InID" value="<%=InID %>" required></td>
	   	</tr>
	   	
	   	<tr>
	        <th>Answer</th>
	        <td><textarea name="IAnswers" value="<%=IAnswers %>" required></textarea></td>
	   	</tr>
	   	
	   		
	   	<tr>
	        <td><button class="edit-btn">Update</button></td>
	   	</tr>
	   	</table>
		
	</form>

</body>
</html>