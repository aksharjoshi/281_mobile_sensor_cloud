package com.resourceallocate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import com.instance.*;

public class ResourceAlocation {

	
	public static void main(String [] argsv) {
		try {
		
		DBConnect db =new DBConnect();
		db.conect();
	
		String query="SELECT DISTINCT * FROM instance_stats a WHERE a.time =(SELECT  MAX(time) time FROM    instance_stats b WHERE   a.External_IP = b.External_IP) and a.date =(SELECT  MAX(date) time FROM    instance_stats b WHERE   a.External_IP = b.External_IP) order by ram_free, disk_free, cpu_utilization";
		
		ResultSet rs = db.execute(query);

		int i=0;
		float max=0;
		String tempIP[]= new String [10000];
		float met[] = new float [10000];
		String tIP= null;	
		int size= 0;
		
		while (rs.next()) {
				
				String[] diskfreestr = rs.getString("disk_free").split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
					
				met[i] = Integer.parseInt(rs.getString("ram_free")) + Integer.parseInt(diskfreestr[0]) +
				
				Float.parseFloat(rs.getString("cpu_utilization"));
				
				 tempIP[i]= rs.getString("External_IP");
				 
				 System.out.println("-----------------------"+ met[i]+tempIP[i]);
				
				 i++;			 
				 size++;
			}
		
		
			for(int j=0;j<size;j++){
				
				
				
			float temp = 0;
				String s = null;
				
			if(met[j]<met[j++]){
				
					temp=met[j];
					met[j]=met[j++];
					met[j++]=temp;
					
					s= tempIP[j];
					tempIP[j]=tempIP[j++];
					tempIP[j++]=s;
					
				}
				
			}
				
			for(int j=0;j<size;j++){
				
				System.out.println("Metric is "+j+" "+ met[j]);
				System.out.println("ResourceIP is "+j+" "+ tempIP[j]);	
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}
