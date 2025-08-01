package ViewFAQ;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/SendInquiry")
public class SendInquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String category = request.getParameter("category");
		String inquiry = request.getParameter("inquiry");
		int CusID =Integer.parseInt(request.getParameter("CusID"));
		
		
		
		
		boolean IsTrue;
		//Add the inquiry to user in the Inquiry table
		ViewFAQDBUtil viewfaq = new ViewFAQDBUtil();
		IsTrue = viewfaq.InsertInquiry(CusID, category, inquiry);
		
		if (IsTrue) {//Send whether it's successfull or not
            request.setAttribute("message", "Inquiry sent successfully.");
        } else {
            request.setAttribute("message", "Failed to send the inquiry.");
        }

        RequestDispatcher dis = request.getRequestDispatcher("inquiryServlet");
        dis.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
