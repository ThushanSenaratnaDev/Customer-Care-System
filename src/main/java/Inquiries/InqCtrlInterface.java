package Inquiries;

import java.util.ArrayList;

public interface InqCtrlInterface {
	public ArrayList<InqModel> getLInq() throws Exception;//Get Loan Inquiries
	public ArrayList<InqModel> getCInq() throws Exception;//Get Card Inquiries
	public ArrayList<InqModel> getAInq() throws Exception;//Get Loan Inquiries
	public ArrayList<InqModel> getPInq() throws Exception;//Get Pawning Inquiries
	public boolean insertdata( int InID, String iAnswers);//Insert Answer to Inquiry
	public  boolean UpdateData(int InAnsID, String IAnswers);//Change Answer in Inquiry_Answer
	public  boolean DeleteData(int InAnsID);//Delete Answer in Inquiry_Answer
	
	
}
