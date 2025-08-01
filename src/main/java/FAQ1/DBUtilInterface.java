package FAQ1;

import java.util.ArrayList;

public interface DBUtilInterface {
	
	
	  boolean ChangeFAQ(int FAQID,String question,String answer);//Change the data in the FAQ table
	  boolean AddFAQ(String question,String answer);//Add new FAQ to the FAQ table
	  boolean DeleteFAQ(int FAQID);//Delete a faq from the table
	  ArrayList<FAQ> getFAQs() throws Exception;//Get All the faq to display them
		
	
}
