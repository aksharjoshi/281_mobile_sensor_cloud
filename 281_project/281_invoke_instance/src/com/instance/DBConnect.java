package com.instance;
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
		jdbcUrl = "jdbc:mysql://sql3.freemysqlhosting.net/sql397168";// + "?user=" + "DB281" + "&password=" + "pankajsingh";
			  
		// Load the JDBC driver
		try {
		    System.out.println("Loading driver...");
		    Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Driver loaded!");
		    
		    conn = DriverManager.getConnection(jdbcUrl,"sql397168","uH2!uF9*");
			setupStatement = conn.createStatement();
			///kYan gayo???
		} 
		catch (Exception e) {
			throw new RuntimeException("Cannot find the driver in the classpath!", e);
		}  
	}
	
	public boolean insert(String query){
		boolean update=false;
		try {	
			update=setupStatement.execute(query);
			
			return update;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return update;
		}
	}
	
	public ResultSet select(String query){
		ResultSet result=null;
		try {
			
			result = setupStatement.executeQuery(query);
			
			return result;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
	}

	public ResultSet execute(String query){
		ResultSet result=null;
		try {
			
			result = setupStatement.executeQuery(query);
			
			return result;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return result;
		}
	}
	
	
	
	
	/*public static void main(String args[]){
		DBConnect db=new DBConnect();
		db.conect();
	}*/
}
