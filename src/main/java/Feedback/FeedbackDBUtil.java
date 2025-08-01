package Feedback;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import FAQ1.DBConnect;

public class FeedbackDBUtil implements FeedbackDBUtilInterface {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	

	//Add feedback to the table
	public boolean insertFeedback(int stars, String feedback, int cusid) {
		
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "INSERT INTO feedback VALUES (0, '" + feedback + "', '" + stars + "', " + cusid + ")";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}
	//Get the logged in user's feedback
	public List<Feedback> getFeedback(int cusid) {
		
		ArrayList<Feedback> fb = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			 String sql = "SELECT f.feid, f.feedback, f.stars, f.cusid, c.name AS customerName " +
                     "FROM feedback f JOIN customer c ON f.cusid = c.cusid " +
                     "WHERE f.cusid = " + cusid;
			
			//String sql = "SELECT * FROM feedback WHERE cusid = " + cusid;
			rs = stmt.executeQuery(sql);		
			
			if(rs.next()) {
				
				int feid = rs.getInt(1);
				String feedback = rs.getString(2);
				int stars = rs.getInt(3);
				int cusId = rs.getInt(4);
				String cusName = rs.getString(5);
				
				Feedback f = new Feedback(feid, stars, feedback, cusId, cusName);
				fb.add(f);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return fb;
	}
	//get all feedback from all the users
	public List<Feedback> getAllFeedbacks() {
		
	    ArrayList<Feedback> fb = new ArrayList<>();
	    
	    try {
	        con = DBConnect.getConnection();
	        stmt = con.createStatement();
	        
	        // Get all feedback including the current user's feedback
	        String sql = "SELECT f.feid, f.feedback, f.stars, f.cusid, c.name AS customerName " +
	        		"FROM feedback f JOIN customer c ON f.cusid = c.cusid";
	        rs = stmt.executeQuery(sql);
	        
	        while (rs.next()) {
	            int feid = rs.getInt(1);
	            String feedback = rs.getString(2);
	            int stars = rs.getInt(3);
	            int cusId = rs.getInt(4);
	            String cusName = rs.getString(5);
	            
	            Feedback f = new Feedback(feid, stars, feedback, cusId, cusName);
	            fb.add(f);
	        }
	        
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	    
	    return fb;
	}

	// update the feedback provided by the user
	public boolean updateFeedback(int stars, String feedbackText, int cusid) {
		
		boolean isSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "UPDATE feedback SET stars = '" + stars + "', feedback = '" + feedbackText +"' WHERE cusid = " + cusid;
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	// remove the users feedback 
	public boolean deleteFeedback(int cusid) {
	    boolean isSuccess = false;

	    try {
	        // Establish database connection
	        con = DBConnect.getConnection();
	        stmt = con.createStatement();

	        // Execute SQL to delete feedback
	        String sql = "DELETE FROM feedback WHERE cusid = " + cusid;
	        int rs = stmt.executeUpdate(sql);

	        if (rs > 0) {
	            isSuccess = true;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return isSuccess;
	}

}

