package ViewFAQ;

import java.io.IOException;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public deleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
boolean isTrue = false;
		
		try {
			//Delete a FAQ from the Inquiry table
			int inID = Integer.parseInt(request.getParameter("inquiryId"));
			ViewFAQDBUtil viewfaq = new ViewFAQDBUtil();
			isTrue = viewfaq.DeleteInquiry(inID);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		if (isTrue) {//Send message whether the inquiry delete was successfull.
	        request.setAttribute("message", "Inquiry deleted successfully.");
	    } else {
	        request.setAttribute("message", "Failed to delete the inquiry.");
	    }

	    RequestDispatcher dis = request.getRequestDispatcher("inquiryServlet");
	    dis.forward(request, response);
	}

}
