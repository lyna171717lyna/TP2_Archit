package Class;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	   
		String BDD = "tp2";
		String url = "jdbc:mysql://localhost:3306/" + BDD;
		String user = "root";
		String passwd = "1234";
		private static Connection conn = null;

	   
	    
	    
	    	
	    	public static Connection getConn() throws SQLException {
				if(conn == null) conn = DriverManager.getConnection(url, user,passwd);
				return conn;
			
		}


		
	
}
