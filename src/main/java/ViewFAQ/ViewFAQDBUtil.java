package ViewFAQ;

import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import FAQ1.DBConnect;


 



public class ViewFAQDBUtil implements ViewFAQInterface {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	ArrayList<Inquiry> cus = new ArrayList<>();
	
	//Insert a logged in customers Inquiry
	public boolean InsertInquiry(int CusID, String category, String inquiry) {
		boolean IsSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql = "Insert Into Inquiries values (0,  '"+inquiry+"'  , '"+CusID+"' ,'"+category+"'  )";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				IsSuccess = true;
			}else {
				IsSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return IsSuccess;
	}
	
	//Get the customer's Inquiries
	public ArrayList<Inquiry> getInquiries(int cusID) throws Exception{
		ArrayList<Inquiry> inquiryList = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql1 = "SELECT Inquiries.InID, Inquiries.Inquiry, Inquiries.CusID, Inquiries.Category, " +
                    "Inquiry_Answers.InAnsID, Inquiry_Answers.IAnswers " +
                    "FROM Inquiry_Answers " +
                    "RIGHT OUTER JOIN Inquiries ON Inquiries.InID = Inquiry_Answers.InID " +
                    "WHERE Inquiries.CusID = ?";     
			
			
			PreparedStatement pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, cusID);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Inquiry inquiry = new Inquiry(rs.getInt("InID"), rs.getString("Category"), rs.getString("Inquiry"), rs.getInt("CusID"),rs.getString("IAnswers"));
				inquiryList.add(inquiry);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return inquiryList;
	}
	
	
		//Update the Inquiry of the customer	
	public boolean UpdateInquiry(int inID,String category, String inquiry) {
				boolean IsSuccess = false;
				
				try {
					
					PreparedStatement pstmt = null;
					con = DBConnect.getConnection();
					stmt = con.createStatement();
					
					String sql2 = "UPDATE Inquiries SET Inquiry = ?, Category = ? WHERE InID = ?";
					pstmt = con.prepareStatement(sql2);
					
					
					pstmt.setString(1, inquiry);
		            pstmt.setString(2, category);
		            pstmt.setInt(3, inID);
					
					int rs = pstmt.executeUpdate();
					
					if(rs > 0) {
						IsSuccess = true;
					}else {
						IsSuccess = false;
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				return IsSuccess;
				}
	
	//Delete the customer's Inquiry
	public boolean DeleteInquiry(int inID) {
		boolean IsSuccess = false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			PreparedStatement pstmt = null;
			
			String sql3 = "DELETE FROM Inquiries WHERE InID =?";
			pstmt = con.prepareStatement(sql3);
			
			 pstmt.setInt(1,inID);
			
			 int rs = pstmt.executeUpdate();
			
			if(rs > 0) {
				IsSuccess = true;
			}else {
				IsSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return IsSuccess;
		}
	
		}
	


