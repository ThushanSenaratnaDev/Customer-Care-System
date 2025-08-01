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

import Login.Customer;


@WebServlet("/FeedbackGet")
public class FeedbackGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FeedbackGet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String password = request.getParameter("pass");
		
		try {
			FeedbackDBUtilInterface fbCtrl = new FeedbackDBUtil();
	           
			
			
			
			


			 HttpSession session1 = request.getSession(false);  // Get the current session without creating a new one
			    int cusid = -1;
			    if (session1 != null && session1.getAttribute("cusID") != null) {
			        cusid = (int) session1.getAttribute("cusID");
			        String userName = (String) session1.getAttribute("username");  // Optional: Retrieve username if stored
			    } else {
			        // Redirect to login page if session is invalid or does not exist
			        response.sendRedirect("Login.jsp");
			    }
	         // Check if the user has already submitted feedback
                List<Feedback> fbDetails = fbCtrl.getFeedback(cusid);
                request.setAttribute("fbDetails", fbDetails);
                
                List<Feedback> fbDetailsAll = fbCtrl.getAllFeedbacks();
        		request.setAttribute("fbDetailsAll", fbDetailsAll);
                
                if (fbDetails != null && !fbDetails.isEmpty()) {
                    // User has already submitted feedback, redirect to all feedbacks page
                    RequestDispatcher dis = request.getRequestDispatcher("allfeedbacks.jsp");
    	    		dis.forward(request, response);
                    
                    return; // Ensure no further code execution
                } else {
                    // No feedback found, show the feedback form
                	RequestDispatcher dis = request.getRequestDispatcher("feedback.jsp");
    	    		dis.forward(request, response);
                }
	       
	        	
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
