package FAQ1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/DeleteFAQServlet")
public class DeleteFAQServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteFAQServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isTrue = false;
		
		try {
			int id = Integer.parseInt(request.getParameter("faqID"));
			FAQDBUtil faq = new FAQDBUtil();
			isTrue = faq.DeleteFAQ( id);//Call the delete function
			
			
			
		}catch(Exception e) {
			
		}
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("AllFAQServlet");
			dis.forward(request,response);//redirect to allfaqservlet if no problem
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("Unsuccess.jsp.jsp");
			dis2.forward(request,response);
		}

	}
	
}
