package Inquiries;

import java.sql.Connection;
import java.sql.DriverManager;

public class CRDBConnection {
	//make darabase connection
	private static String url = "jdbc:mysql://localhost:3306/OOP";
	private static String user = "root";
	private static String password = "";
	private static Connection con;
	
	public static Connection getConnection () {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
		}
		catch(Exception e) {
			System.out.println("Database Not Connect Successfully !");
		}
		return con;
	}

}
