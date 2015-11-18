package com.sensor;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import com.instance.*;

public class Sensor {

	public static final void main(String... aArgs) throws IOException{
		System.out.println("Generating 10 random integers in range 0..99.");
	    
	    //note a single Random object is reused here
	    Random randomGenerator = new Random();
	   // for (int idx = 1; idx <= 10; ++idx){
	      int randomInt = randomGenerator.nextInt(100000);
	      System.out.println("Generated : " + randomInt);
	    //}	    
	      
	    String content = "Sensor_id\tData\n\t\t1\t"+randomInt;

		File file = new File("./sensor.log");

			// if file doesnt exists, then create it
		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(content);
		
		bw.close();

		System.out.println("Done");
			
			
	    System.out.println("Done.");
	    
	    DBConnect db=new DBConnect();
	    db.conect();
	    
	    String query="Select * from DB281.Sensor_id";
	    
	    ResultSet res=db.select(query);
	    int id=0;
	    try {
	    	while(res.next()){
	    		id=Integer.parseInt(res.getString(1));
	    		System.out.println(res.getString(1)+"\nId val is: "+id);
	    	}
	    	int old_id=id;
	    	id++;
	    	
	    	query="update Sensor_id set sensor_count_id="+id+" where sensor_count_id="+old_id;
	    	
	    	if(!(db.insert(query))){
	    		System.out.println("count updated");
	    	}
	    	else
	    	{
	    		System.out.println("count update failed");
	    	}
		}
	    catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	  }
}
