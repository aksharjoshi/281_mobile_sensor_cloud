import java.util.ArrayList;
import java.util.List;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2Client;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;

public class demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AmazonEC2 amazonEC2Client = new AmazonEC2Client(new BasicAWSCredentials("AKIAJHEL4MLCNCDCRJIQ", "cVdp6+T7Z4TCjJHJQk4eXaei8p1Cl/23fS8cSsVO"));
		
		amazonEC2Client.setEndpoint("ec2.us-west-2.amazonaws.com");
		
		DescribeInstancesRequest ir=new DescribeInstancesRequest();
		//ir.withInstanceIds(runInstancesResult.getReservation().getInstances().get(0).getInstanceId());
	
		//List<String> publicIpsList = new ArrayList<String>();
		
		ir.withInstanceIds("i-6f117eab");
		
		DescribeInstancesResult ires=amazonEC2Client.describeInstances(ir);
		
		//List<Reservation> reservations = ires.getReservations();
		Reservation reservations= ires.getReservations().get(0);
		
		Instance instances= reservations.getInstances().get(0);
		
		
		System.out.println("IP add is: "+instances.getPublicIpAddress());
		/*
		for(Reservation res : reservations){
			instances = res.getInstances();
			for(Instance ins : instances){
				System.out.println("PublicIP from " + ins.getImageId() + " is " + ins.getPublicIpAddress());
				publicIpsList.add(ins.getPublicIpAddress());
				ins.getPublicIpAddress();
			}
		}
		*/
		dm();
	}
	
	static void dm(){
		
		AmazonEC2 amazonEC2Client = new AmazonEC2Client(new BasicAWSCredentials("AKIAJHEL4MLCNCDCRJIQ", "cVdp6+T7Z4TCjJHJQk4eXaei8p1Cl/23fS8cSsVO"));
		
		amazonEC2Client.setEndpoint("ec2.us-west-2.amazonaws.com");
		
		DescribeInstancesRequest ir=new DescribeInstancesRequest();
		ir.withInstanceIds("i-6f117eab");
	
		
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
		
		while(true){
			if(ires.getReservations().get(0).getInstances().get(0).getState().getName().toString()!="pending"){
				break;
			}
		}
		System.out.println(ires.getReservations().get(0).getInstances().get(0).getPublicIpAddress().toString());
	}

}
