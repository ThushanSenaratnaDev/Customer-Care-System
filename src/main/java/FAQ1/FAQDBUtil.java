package FAQ1;
//FAQ controller
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import Interface.CRUDInterface;

public class FAQDBUtil implements DBUtilInterface {
	
	private static Connection con =null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	
	public  boolean AddFAQ(String question,String answer) {//Add faq to table
		
		boolean isSuccess = false;
		
		
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			
			String sql2 = "Insert into FAQ values(0,'"+question+"','"+answer+"') ";
			int rs = stmt.executeUpdate(sql2);
			
			if(rs>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return isSuccess;
	}
	
	
	public ArrayList<FAQ> getFAQs() throws Exception{//retreive all faq from the table
		
		ArrayList<FAQ> faqList = new ArrayList<>();
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql3 = "SELECT * FROM FAQ";
			rs =stmt.executeQuery(sql3);
			
			while (rs.next()) {
				FAQ faq = new FAQ(rs.getString("Question"),rs.getString("Answer"),rs.getInt("FAQID"));
				faqList.add(faq);
				
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return faqList;
		
	}
	
	public  boolean ChangeFAQ(int FAQID,String question,String answer){//update the faq
		boolean isSuccess= false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql3 = "Update FAQ SET Question ='"+question+"' , Answer='"+answer+"'  WHERE FAQID='"+FAQID+"'";
			int rs = stmt.executeUpdate(sql3);
			
			if(rs>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	
	public boolean DeleteFAQ(int FAQID) {//delete faqs from the table
		boolean isSuccess=false;
		
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			String sql4 = "Delete FROM FAQ WHERE FAQID='"+FAQID+"'";
			int rs = stmt.executeUpdate(sql4);
			
			if(rs>0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return isSuccess;
	}
	
}
