package ViewFAQ;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/inquiryServlet")
public class inquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public inquiryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null|| session.getAttribute("cusID")==null) {
			response.sendRedirect("Login.jsp");
		}
		
		int CusID = (int) session.getAttribute("cusID");
		
		
		try {
			//Get all the Inquiry from the logged in user
			ViewFAQDBUtil viewfaq = new ViewFAQDBUtil();
			ArrayList<Inquiry> inquiryList = viewfaq.getInquiries(CusID);
			
			request.setAttribute("inquiryList", inquiryList);
			
			request.getRequestDispatcher("inquiry.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
