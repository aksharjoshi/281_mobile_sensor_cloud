import java.sql.*;

public class DBConnect {
	
	String jdbcUrl;
	Connection conn = null;
	Statement setupStatement = null;
	Statement readStatement = null;
	ResultSet resultSet = null;
	String results = "";
	int numresults = 0;
	String statement = null;
	
	
	public void conect(){
		jdbcUrl = "jdbc:mysql://db281.clrlbs6tldgl.us-west-2.rds.amazonaws.com:3306/DB281";// + "?user=" + "DB281" + "&password=" + "pankajsingh";
			  
		// Load the JDBC driver
		try {
		    System.out.println("Loading driver...");
		    Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Driver loaded!");
		} 
		catch (ClassNotFoundException e) {
			throw new RuntimeException("Cannot find the driver in the classpath!", e);
		}
			  
	}
	
	public boolean insert(String query){
		boolean update=false;
		try {
			conn = DriverManager.getConnection(jdbcUrl,"DB281","pankajsingh");
			setupStatement = conn.createStatement();
			
			update=setupStatement.execute(query);
			
			return update;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return update;
		}
	    
	    // Create a table and write two rows
	    
	}

	/*public static void main(String args[]){
		DBConnect db=new DBConnect();
		db.conect();
	}*/
}
