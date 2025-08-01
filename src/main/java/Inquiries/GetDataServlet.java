package Inquiries;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/GetDataServlet")
public class GetDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public GetDataServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		
	    String inquiryType = request.getParameter("inquiryType");
	    
	    //Loan Inquiries
	    if("loan".equals(inquiryType)) {
	    	
	    	 try {
		            
	    		 
	    		 	InqCtrl inqctrl = new InqCtrl();
	    		 	//Get all loan Inquiries
		            ArrayList<InqModel> InqList = inqctrl.getLInq();
		           
		            
		            request.setAttribute("InqList", InqList);
		            
		          
		            request.getRequestDispatcher("LoanInq.jsp").forward(request, response);
		        } catch (Exception e) {
		            e.printStackTrace();
		            
		        }
	    	
	    }
	    //Card Inquiries
	    else if("card".equals(inquiryType)) {
	    	
	    	 try {
	    		 	InqCtrl inqctrl = new InqCtrl();
		            ArrayList<InqModel> InqList = inqctrl.getCInq();
		           
		            
		            request.setAttribute("InqList", InqList);
		            
		            //Get all //Card Inquiries
		            request.getRequestDispatcher("CardInq.jsp").forward(request, response);
		        } catch (Exception e) {
		            e.printStackTrace();
		            
		        }
	    	
	    }
	    //Account Inquiries
	    else if("account".equals(inquiryType)) {
	    	
	    	 try {
	    		 	InqCtrl inqctrl = new InqCtrl();
		            ArrayList<InqModel> InqList = inqctrl.getAInq();
		           
		            //Get all Account Inquiries
		            request.setAttribute("InqList", InqList);
		            
		          
		            request.getRequestDispatcher("AccountInq.jsp").forward(request, response);
		        } catch (Exception e) {
		            e.printStackTrace();
		            
		        }
	    }
	    	//Pawning Inquiries
	    	 else if("pawn".equals(inquiryType)) {
			    	
			    	 try {
			    		 	InqCtrl inqctrl = new InqCtrl();
			    		 	//Get All Pawning Inquiries
				            ArrayList<InqModel> InqList = inqctrl.getPInq();
				           
				            
				            request.setAttribute("InqList", InqList);
				            
				          
				            request.getRequestDispatcher("PawnInq.jsp").forward(request, response);
				        } catch (Exception e) {
				            e.printStackTrace();
				            
				        }
	    	
	    }else {
	    	
	    	 request.getRequestDispatcher("Inq.jsp").forward(request, response);
	    }

		
	    
	}
	
	
	
	
	

	


}