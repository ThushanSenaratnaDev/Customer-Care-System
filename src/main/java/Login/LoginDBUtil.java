package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import FAQ1.DBConnect;

public class LoginDBUtil {

	private static Connection con =null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static int ValidateUser(String username, String password) {
	    int cusID = -1;  // Default value if not found
	    
	    try {
	        // Get database connection
	        con = DBConnect.getConnection();
	        
	        // Prepare SQL query to prevent SQL injection
	        String sql = "SELECT CusID FROM Customer WHERE CusUserName = ? AND CusPassword = ?";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        
	        // Set the username and password in the query
	        pstmt.setString(1, username);
	        pstmt.setString(2, password);
	        
	        // Execute query
	        rs = pstmt.executeQuery();
	        
	        // Check if a result was returned
	        if (rs.next()) {
	            cusID = rs.getInt("CusID");  // Get the customer ID if credentials match
	        }
	    } catch (Exception e) {
	        e.printStackTrace();  // Log or print exception for debugging
	    } finally {
	        // Always close resources
	        try {
	            if (rs != null) rs.close();
	            
	            if (con != null) con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return cusID;  // Return the customer ID if found, -1 otherwise
	}
	
	
	
	public static int ValidateEmployee(String username, String password) {
	    int EID = -1;  // Default value if not found
	    
	    try {
	        // Get database connection
	        con = DBConnect.getConnection();
	        
	        // Prepare SQL query to prevent SQL injection
	        String sql = "SELECT EID FROM Manager_Customer_Representative WHERE EUserName = ? AND EPassword = ?";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        
	        // Set the username and password in the query
	        pstmt.setString(1, username);
	        pstmt.setString(2, password);
	        
	        // Execute query
	        rs = pstmt.executeQuery();
	        
	        // Check if a result was returned
	        if (rs.next()) {
	            EID = rs.getInt("EID");  // Get the customer ID if credentials match
	        }
	    } catch (Exception e) {
	        e.printStackTrace();  // Log or print exception for debugging
	    } finally {
	        // Always close resources
	        try {
	            if (rs != null) rs.close();
	            
	            if (con != null) con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return EID;  // Return the customer ID if found, -1 otherwise
	}
	
	
	
	
}
