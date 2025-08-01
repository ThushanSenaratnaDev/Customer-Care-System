package Feedback;

import java.util.List;

public interface FeedbackDBUtilInterface {
	//public List<Customer> validate(String userName, String password);
	
	public boolean insertFeedback(int stars, String feedback, int cusid);//Add feedback
	
	public List<Feedback> getFeedback(int cusid);//Get the logged in user's feedback
	
	public List<Feedback> getAllFeedbacks();//Get all feedback from the table
	
	public boolean updateFeedback(int stars, String feedbackText, int cusid);//Update feedback
	
	public boolean deleteFeedback(int cusid);//Delete feedback from the table
}

