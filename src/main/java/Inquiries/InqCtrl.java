package Inquiries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InqCtrl implements InqCtrlInterface {
	
	//Connect DB
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	//GetData Loan Method
public  ArrayList<InqModel> getLInq() throws Exception{
		
		ArrayList<InqModel> InqList = new ArrayList<>();
		
		try {
			con = CRDBConnection.getConnection();
			stmt = con.createStatement();
			
			String sql3 = "SELECT * FROM Inquiries LEFT OUTER JOIN Inquiry_Answers ON Inquiries.InID = Inquiry_Answers.InID WHERE Inquiries.Category = 'Loan'";
			rs =stmt.executeQuery(sql3);
			
			while (rs.next()) {
				InqModel inq = new InqModel(rs.getInt("InID"),rs.getString("Inquiry"),rs.getInt("CusID"),rs.getString("Category"),rs.getString("IAnswers"),rs.getInt("InAnsID"));
			//	System.out.println("InqID: " + inq.getInID() + " Inquiry: " + inq.getInquiry());
				InqList.add(inq);
				
				
			}
			//public InqModel(int inID, String inquiry, int cusID, String category,String IAnswer)
			//InID, Inquiry, CusID, Category, InAnsID, InID, IAnswers
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return InqList;
		
	}
	
	
//GetData Card Method
public  ArrayList<InqModel> getCInq() throws Exception{
		
		ArrayList<InqModel> InqList = new ArrayList<>();
		
		try {
			con = CRDBConnection.getConnection();
			stmt = con.createStatement();
			
			String sql3 = "SELECT * FROM Inquiries LEFT OUTER JOIN Inquiry_Answers ON Inquiries.InID = Inquiry_Answers.InID WHERE Inquiries.Category = 'cards'";
			rs =stmt.executeQuery(sql3);
			
			while (rs.next()) {
				InqModel inq = new InqModel(rs.getInt("InID"),rs.getString("Inquiry"),rs.getInt("CusID"),rs.getString("Category"),rs.getString("IAnswers"),rs.getInt("InAnsID"));
			//	System.out.println("InqID: " + inq.getInID() + " Inquiry: " + inq.getInquiry());
				InqList.add(inq);
				
				
			}
			//public InqModel(int inID, String inquiry, int cusID, String category,String IAnswer)
			//InID, Inquiry, CusID, Category, InAnsID, InID, IAnswers
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return InqList;
		
	}



//GetData Account Method
public  ArrayList<InqModel> getAInq() throws Exception{
	
	ArrayList<InqModel> InqList = new ArrayList<>();
	
	try {
		con = CRDBConnection.getConnection();
		stmt = con.createStatement();
		
		String sql3 = "SELECT * FROM Inquiries LEFT OUTER JOIN Inquiry_Answers ON Inquiries.InID = Inquiry_Answers.InID WHERE Inquiries.Category = 'Account'";
		rs =stmt.executeQuery(sql3);
		
		while (rs.next()) {
			InqModel inq = new InqModel(rs.getInt("InID"),rs.getString("Inquiry"),rs.getInt("CusID"),rs.getString("Category"),rs.getString("IAnswers"),rs.getInt("InAnsID"));
		//	System.out.println("InqID: " + inq.getInID() + " Inquiry: " + inq.getInquiry());
			InqList.add(inq);
			
			
		}
		//public InqModel(int inID, String inquiry, int cusID, String category,String IAnswer)
		//InID, Inquiry, CusID, Category, InAnsID, InID, IAnswers
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	return InqList;
	
}
	
//GetData Pawning Inquiries Method
public  ArrayList<InqModel> getPInq() throws Exception{
	
	ArrayList<InqModel> InqList = new ArrayList<>();
	
	try {
		con = CRDBConnection.getConnection();
		stmt = con.createStatement();
		
		String sql3 = "SELECT * FROM Inquiries LEFT OUTER JOIN Inquiry_Answers ON Inquiries.InID = Inquiry_Answers.InID WHERE Inquiries.Category = 'Pawning'";
		rs =stmt.executeQuery(sql3);
		
		while (rs.next()) {
			InqModel inq = new InqModel(rs.getInt("InID"),rs.getString("Inquiry"),rs.getInt("CusID"),rs.getString("Category"),rs.getString("IAnswers"),rs.getInt("InAnsID"));
		//	System.out.println("InqID: " + inq.getInID() + " Inquiry: " + inq.getInquiry());
			InqList.add(inq);
			
			
		}
		//public InqModel(int inID, String inquiry, int cusID, String category,String IAnswer)
		//InID, Inquiry, CusID, Category, InAnsID, InID, IAnswers
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
	
	return InqList;
	
}


	
	
//Add Answer to Inquiries
	public  boolean insertdata( int InID, String iAnswers) {
		
		boolean isSuccess = false;
		try {
			//DB Connection Call
			con = CRDBConnection.getConnection();
			stmt = con.createStatement();
			
			//SQL Query
			String sql = "Insert into inquiry_answers Values (0, '"+InID+"', '"+iAnswers+"') ";
			int rs = stmt.executeUpdate(sql);
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		return isSuccess;
	}
	

	

	
	//Update Answer to Inquiries
	public  boolean UpdateData(int InAnsID, String IAnswers) {
		
		try {
			
			//DB Connection Call
			con = CRDBConnection.getConnection();
			stmt = con.createStatement();
			
			//SQL Query
			String sql = "update Inquiry_Answers set IAnswers='"+IAnswers+"' "
					+"where InAnsID = '"+InAnsID+"'";
			
			int rs = stmt.executeUpdate(sql);
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return isSuccess; 
	}
	
	//Delete Inquiry Answer
	public  boolean DeleteData(int InAnsID) {
		
		
		try {
			
			//DB Connection
			con = CRDBConnection.getConnection();
			stmt = con.createStatement();
			
			//SQL Query
			String sql = "delete from Inquiry_Answers where InAnsID='"+InAnsID+"' ";
			
			int rs = stmt.executeUpdate(sql);
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return isSuccess; 		
		
	}




}
