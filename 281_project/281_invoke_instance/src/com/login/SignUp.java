package com.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.instance.*;

public class SignUp extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);

		DBConnect db = new DBConnect();
		db.conect();
		
		RequestDispatcher dd = req.getRequestDispatcher("Login.jsp");
		
		
		int count=0;
		String phone=null;
		String firstName = null;
		String lastName= null;
		String userName=null;
		String password=null;
		String city=null;
		String country=null;
		String state=null;
		
		
		firstName=req.getParameter("FirstName");

	    lastName=req.getParameter("LastName");

	    userName=req.getParameter("UserName");

	    password=req.getParameter("Password");
		
	    phone = req.getParameter("Phone");
		
	    city=req.getParameter("City");

		state=req.getParameter("State");

		country=req.getParameter("Country");
	
		String query="INSERT INTO user_details_tbl (firstname,lastname,username,password,phone_number,city,state,country)"+
				" VALUES ('"+firstName+"','"+
				lastName+"','"+userName+"','"+password+"','"+phone+
				"','"+city+"','"+state+"','"+country+"')";	
		
		if(!(db.insert(query))){
			count++;
			System.out.println("insert successful");
			System.out.println("query was: \n"+query);
			dd.forward(req, resp);		
		
		}
		else{
			System.out.println("query failed");
			System.out.println("query was: \n"+query);
		}

		
		
		
	}

	
	
}
