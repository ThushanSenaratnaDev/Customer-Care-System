package FAQ1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//Update the faqs
@WebServlet("/UpdateFAQServlet")
public class UpdateFAQServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateFAQServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Question = request.getParameter("question");
		String answer = request.getParameter("answer");
		boolean isTrue=false;
		
		
		
		try {
			
			int id = Integer.parseInt(request.getParameter("faqID"));
			
			FAQDBUtil faq1 = new FAQDBUtil();
			isTrue = faq1.ChangeFAQ(id, Question, answer);//Call the faq update function
			//isTrue = FAQDBUtil.ChangeFAQ( id,Question,answer);
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
		
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("AllFAQServlet");
			dis.forward(request,response);
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("Unsuccess.jsp.jsp");
			dis2.forward(request,response);
		}
	}

}
