package ViewFAQ;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import FAQ1.FAQ;
import FAQ1.FAQDBUtil;


@WebServlet("/ViewFAQCustomerServlet")
public class ViewFAQCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewFAQCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		 try {
	            // Fetching FAQs from the DB using FAQDBUtil
	           
			 FAQDBUtil faq = new FAQDBUtil();
			 ArrayList<FAQ> faqList = faq.getFAQs();
	           
	            
	      
	            
	            // Passing the FAQ list to the JSP page
	            request.setAttribute("faqList", faqList);
	            
	            // Forwarding the request to the JSP page
	            request.getRequestDispatcher("ViewFAQ.jsp").forward(request, response);
	        } catch (Exception e) {
	            e.printStackTrace();
	            // Handle database errors (optional: show error message in JSP)
	        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
