package ViewFAQ;

import java.util.ArrayList;

public interface ViewFAQInterface {
	public boolean InsertInquiry(int CusID, String category, String inquiry);
	public ArrayList<Inquiry> getInquiries(int cusID) throws Exception;
	public boolean UpdateInquiry(int inID,String category, String inquiry);
	public boolean DeleteInquiry(int inID);
	
	
}
