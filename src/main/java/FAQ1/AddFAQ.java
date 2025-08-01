package FAQ1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/AddFAQ")
public class AddFAQ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//This adds FAQs to the database
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Question = request.getParameter("question");
		String answer = request.getParameter("answer");
		boolean isTrue;
		
		FAQDBUtil faq = new FAQDBUtil();
		isTrue = faq.AddFAQ(Question, answer);//Call addFAQ method to add data
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("AllFAQServlet");
			dis.forward(request,response);//If no problem redirect to show the faqs
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("Unsuccess.jsp");
			dis2.forward(request,response);
		}
	}

}
