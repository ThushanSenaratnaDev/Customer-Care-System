package Inquiries;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/InqInsertServlet")
public class InqInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int InID = Integer.parseInt(request.getParameter("InID"));
		int InAnsID = Integer.parseInt(request.getParameter("InAnsID"));
		String IAnswers = request.getParameter("IAnswers");
		String Send = request.getParameter("Send");
		
		boolean isTrue;
		//If send button is clicked it will add data to the Inquiry_Answers
		if("Send".equals(Send)) {
		
			
			InqCtrl inqctrl = new InqCtrl();
			isTrue = inqctrl.insertdata(InID, IAnswers);
		
		
			if(isTrue == true) {
				String alertMessage = "Data Insert Successful";
				response.getWriter().println("<script> alert('"+alertMessage+"'); window.location.href='GetDataServlet'</script>");
				
			}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request, response);

		}
	
			//public static boolean UpdateData(int InAnsID, int InID, String IAnswers)
			//If Update button is clicked it will Update Answer to the Inquiry_Answers	
		}else if("Update".equals(Send)) {
			
			InqCtrl inqctrl = new InqCtrl();
			isTrue = inqctrl.UpdateData(InAnsID,IAnswers );
			
			
			if(isTrue == true) {
				String alertMessage = "Data Updated Successful";
				response.getWriter().println("<script> alert('"+alertMessage+"'); window.location.href='GetDataServlet'</script>");
			
			}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request, response);

		}
			
			
			
			
			
			
			
			//If Delete button is clicked it will Delete data in the Inquiry_Answers	
		}else if("Delete".equals(Send)) {
			
			InqCtrl inqctrl = new InqCtrl();
			//public static boolean DeleteData(int InAnsID)
			isTrue = inqctrl.DeleteData(InAnsID);
			
			
			if(isTrue == true) {
				String alertMessage = "Data Deleted Successful";
				response.getWriter().println("<script> alert('"+alertMessage+"'); window.location.href='GetDataServlet'</script>");
			
			}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("wrong.jsp");
			dis2.forward(request, response);

		}
			
			
		
		}
	}

}
