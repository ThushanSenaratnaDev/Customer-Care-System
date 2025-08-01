package ViewFAQ;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/updateInquiryServlet")
public class updateInquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public updateInquiryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
				String category = request.getParameter("category");
				String inquiry = request.getParameter("newInquiry");
				String answer = request.getParameter("answer");
				boolean isTrue = false;
				
				try {//Update the logged user's Inquiry
					int inID = Integer.parseInt(request.getParameter("inquiryId"));
					ViewFAQDBUtil viewfaq = new ViewFAQDBUtil();
					isTrue = viewfaq.UpdateInquiry(inID, category, inquiry);
				}catch(Exception e) {
					System.out.println(e);
				}
				
				if (isTrue) {//Send whether is successfull or not
		            request.setAttribute("message", "Inquiry updated successfully.");
		        } else {
		            request.setAttribute("message", "Failed to update the inquiry.");
		        }

		        RequestDispatcher dis = request.getRequestDispatcher("inquiryServlet");
		        dis.forward(request, response);
			}

		

		
		
	}


