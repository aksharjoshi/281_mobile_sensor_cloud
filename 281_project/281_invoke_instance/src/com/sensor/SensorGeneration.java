package com.sensor;

import java.io.File;
import java.io.IOException;

public class SensorGeneration {

	public void createSensor(int sensor_id, String user_id){
		try {
			ProcessBuilder pb= new ProcessBuilder("/Users/Akshar/Documents/281_project/281_invoke_instance/src/com/testScript/test.sh "+sensor_id+" "+user_id);
			System.out.println(pb.start().toString());
			//System.out.println(pb.redirectOutput(new File("/Users/Akshar/Documents/281_project/281_invoke_instance/src/com/testScript/output.log")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
