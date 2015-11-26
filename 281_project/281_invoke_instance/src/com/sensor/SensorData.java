package com.sensor;

import java.util.Date;
import java.util.Random;

import com.instance.DBConnect;

public class SensorData {

	public void sendData(int sensor_id, String sensor_type, String name){
		Random randomGenerator = new Random();
		   // for (int idx = 1; idx <= 10; ++idx){
		int randomInt = randomGenerator.nextInt(100000);
		System.out.println("Generated : " + randomInt);
		    //}	    
		      
		Date time=new Date();
		String timestamp=time.getTime()+"";
		
		String query="insert into Sensor_data values ("+sensor_id+",'"+randomInt+"','"+timestamp+"','"
					  +sensor_type+"','"+name+"')";
		
		DBConnect db=new DBConnect();
		
		db.conect();
		
		if(!db.insert(query)){
			System.out.println("data insert succesful for sensor: "+sensor_id);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sensor_id=Integer.parseInt(args[0]);
		String type=args[1];
		String name=args[2];
		SensorData sd=new SensorData();
		
		while(true){
			sd.sendData(sensor_id,type,name);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
