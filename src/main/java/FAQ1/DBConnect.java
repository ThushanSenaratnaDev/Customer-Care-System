package FAQ1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	//Make connection with the database
	private static String url = "jdbc:mysql://localhost:3306/OOP";
	private static String user = "root";
	private static String password = "";
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			
		}catch(Exception e){
			System.out.println("Database connection not successfull");
		}
		return con;
		
	}
}
