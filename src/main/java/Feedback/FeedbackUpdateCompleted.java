package Feedback;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/FeedbackUpdateCompleted")
public class FeedbackUpdateCompleted extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
        int cusid = Integer.parseInt(request.getParameter("cusid"));
        int stars = Integer.parseInt(request.getParameter("stars"));
        String feedbackText = request.getParameter("feedback");
        
        FeedbackDBUtilInterface fbCtrl = new FeedbackDBUtil();

        // Update feedback in the database using cusid
        boolean isUpdated = fbCtrl.updateFeedback(stars, feedbackText, cusid);
        
        //Get current users feedback
        List<Feedback> fbDetails = fbCtrl.getFeedback(cusid);
		request.setAttribute("fbDetails", fbDetails);
		
		//Get All users feedback
		List<Feedback> fbDetailsAll = fbCtrl.getAllFeedbacks();
		request.setAttribute("fbDetailsAll", fbDetailsAll);

        // Redirect to allfeedbacks.jsp page after update
        if (isUpdated) {
        	request.setAttribute("updateSuccessMessage", "Feedback updated successfully.");
            RequestDispatcher dis = request.getRequestDispatcher("allfeedbacks.jsp");
            dis.forward(request, response);
        } else {
            RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
            dis2.forward(request, response);
        }
	}

}
