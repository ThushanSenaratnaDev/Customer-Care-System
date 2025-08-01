package Feedback;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;


@WebServlet("/FeedbackInsert")
public class FeedbackInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//get feedback and the number of stars
		int stars = Integer.parseInt(request.getParameter("stars"));
		String feedback = request.getParameter("feedback");

		boolean isTrue;
		//Get cusID from the session
		HttpSession session = request.getSession();
	    Integer cusid = (Integer) session.getAttribute("cusID");
		
	    if (cusid == null) {
	        System.out.println("Error");
	    }
		
	    FeedbackDBUtilInterface fbCtrl = new FeedbackDBUtil();
	    //Insert Feedback
		isTrue = fbCtrl.insertFeedback(stars, feedback, cusid);
		
		//Get your Feeedback
		List<Feedback> fbDetails = fbCtrl.getFeedback(cusid);
		request.setAttribute("fbDetails", fbDetails);
		
		//Get all feedback
		List<Feedback> fbDetailsAll = fbCtrl.getAllFeedbacks();
		request.setAttribute("fbDetailsAll", fbDetailsAll);
		
		//Check if feedback inserted successfully
		if(isTrue == true) {
			request.setAttribute("insertSuccessMessage", "Feedback inserted successfully.");
			RequestDispatcher dis = request.getRequestDispatcher("allfeedbacks.jsp");
			dis.forward(request, response);
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("ViewFAQCustomerServlet");
			dis2.forward(request, response);
		}
	}

}
