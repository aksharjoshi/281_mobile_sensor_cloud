package com.instance;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.autoscaling.model.Tag;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.AuthorizeSecurityGroupIngressRequest;
import com.amazonaws.services.ec2.model.CreateKeyPairRequest;
import com.amazonaws.services.ec2.model.CreateKeyPairResult;
import com.amazonaws.services.ec2.model.CreateSecurityGroupRequest;
import com.amazonaws.services.ec2.model.CreateSecurityGroupResult;
import com.amazonaws.services.ec2.model.CreateTagsRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.IpPermission;
import com.amazonaws.services.ec2.model.KeyPair;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;

public class InvokeInstance {

	public static void main(String[] args) throws InterruptedException {
		
	
		// TODO Auto-generated method stub
		AWSCredentials credentials = new ProfileCredentialsProvider().getCredentials();
				//new PropertiesCredentials(AwsConsoleApp.class.getResourceAsStream("credentials"));

		AmazonEC2 amazonEC2Client = new AmazonEC2Client(new BasicAWSCredentials("AKIAJHEL4MLCNCDCRJIQ", "cVdp6+T7Z4TCjJHJQk4eXaei8p1Cl/23fS8cSsVO"));
		
		//new AmazonEC2Client(new BasicAWSCredentials("AKIAI32NAJBWBXFWKXPQ", "fbQTu9ERdPKdkKFycmnDIgMpQ2ziphaiFIHjXUw6"));
		
		amazonEC2Client.setEndpoint("ec2.us-west-2.amazonaws.com");
		/*List <String>name=new ArrayList<String>();
		List <String>value=new ArrayList<String>();
		
		CreateTagsRequest createTagsRequest=new CreateTagsRequest();
		
		amazonEC2Client.createTags(createTagsRequest);
		*/
		
		RunInstancesRequest runInstancesRequest = new RunInstancesRequest();
			        	
		
		runInstancesRequest.withImageId("ami-a6b3a2c7")
		                   .withInstanceType("t2.micro")
		                   .withMinCount(1)
		                   .withMaxCount(1)
		                   .withKeyName("MobileSensorKey1")
		                   //.withKeyName("Hello_281")
		                   .withSecurityGroups("launch-wizard-2");
		                   //.withSecurityGroups("launch-wizard-1");
		                   //.withSecurityGroups("JavaSecurityGroup");
		
		
			  
		RunInstancesResult runInstancesResult = amazonEC2Client.runInstances(runInstancesRequest);
	
		System.out.println(runInstancesResult.toString() + "\n");
		
		DescribeInstancesRequest ir=new DescribeInstancesRequest();
		ir.withInstanceIds(runInstancesResult.getReservation().getInstances().get(0).getInstanceId());
	
		
		DescribeInstancesResult ires=amazonEC2Client.describeInstances(ir);
		
		//	createTagsRequest.withResources(runInstancesResult.getReservation().getInstances().get(0).getInstanceId()).setTags("Name", "TestInstance");
		//System.out.println(runInstancesResult.toString());
//		System.out.println("\n"+ires.getReservations().get(1).getInstances().get(0).getPublicIpAddress().toString());

		System.out.println(ires.toString());
		
		//ires.getReservations().get(1).getInstances().get(0).getPublicIpAddress().toString();
		
		/*ires.getReservations().get(1).getInstances().get(0)
		getInstances().get(0).getPublicIpAddress().toString();
		*/
		InvokeInstance ii = new InvokeInstance();
		
		String state=ires.getReservations().get(0).getInstances().get(0).getState().getName().toString();
		
		System.out.println("state is: "+state);
		
		while(!state.equals("running")){
			//if(ires.getReservations().get(0).getInstances().get(0).getState().getName().toString()!="pending"){
				//break;
			//}
			ires=amazonEC2Client.describeInstances(ir);
			state=ires.getReservations().get(0).getInstances().get(0).getState().getName().toString();
			System.out.println("Running state is: "+state);
			Thread.sleep(5000);
		}
		ii.dbOperation(ires);
	}

	public void dbOperation(DescribeInstancesResult ires){
		DBConnect db=new DBConnect();
		db.conect();
		
		DBInsert dbi=new DBInsert();
		
		//Reservation res=new Reservation();
		
		System.out.println("ires = \n"+ires.toString());
		
		//System.out.println("res.getinstance"+res.getInstances().toString());
		
		while(true){
			if(ires.getReservations().get(0).getInstances().get(0).getState().getName().toString()!="pending"){
				break;
			}
		}
		System.out.println(ires.getReservations().get(0).getInstances().get(0).getPublicIpAddress().toString());
		
		dbi.setGroupId(ires.getReservations().get(0).getInstances().get(0).getSecurityGroups().get(0).getGroupId().toString());

		dbi.setGroupName(ires.getReservations().get(0).getInstances().get(0).getSecurityGroups().get(0).getGroupName().toString());
		
		dbi.setPublicIpAddress(ires.getReservations().get(0).getInstances().get(0).getPublicIpAddress().toString());
		//.get(0).getPublicIpAddress().toString());
		
		dbi.setInstanceId(ires.getReservations().get(0).getInstances().get(0).getInstanceId().toString());
		
		dbi.setOwnerId(ires.getReservations().get(0).getOwnerId().toString());
		
		dbi.setImageId(ires.getReservations().get(0).getInstances().get(0).getImageId().toString());
		
		dbi.setInstanceType(ires.getReservations().get(0).getInstances().get(0).getInstanceId().toString());
		
		dbi.setKeyName(ires.getReservations().get(0).getInstances().get(0).getKeyName().toString());
		
		dbi.setPrivateIpAddress(ires.getReservations().get(0).getInstances().get(0).getPrivateIpAddress().toString());
		
		dbi.setVpcId(ires.getReservations().get(0).getInstances().get(0).getVpcId().toString());
		
		dbi.setStatus("Active");
		
		String query="INSERT INTO instance_info (InstanceId,"+
				"OwnerId,ImageId,KeyName,InstanceType,VpcId,PublicIpAddress,PrivateIpAddress,"+
				"GroupId,GroupName,Status) VALUES ('"+dbi.getInstanceId()+"','"+dbi.getOwnerId()+"','"+
				dbi.getImageId()+"','"+dbi.getKeyName()+"','"+dbi.getInstanceType()+"','"+dbi.getVpcId()+
				"','"+dbi.getPublicIpAddress()+"','"+dbi.getPrivateIpAddress()+"','"+dbi.getGroupId()+"','"+
				dbi.getGroupName()+"','"+dbi.getStatus()+"')";	
		
		if(!(db.insert(query))){
			System.out.println("insert successful");
			System.out.println("query was: \n"+query);
		}
		else{
			System.out.println("query failed");
			System.out.println("query was: \n"+query);
		}
	}
}
