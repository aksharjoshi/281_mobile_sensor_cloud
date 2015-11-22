package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Login extends HttpServlet {

	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		String Username=req.getParameter("Username");

		String Password=req.getParameter("Password");

	
		if (Username.equals("admin@admin.com") && Password.equals("admin"))
		{
			resp.sendRedirect("AdminDashboard.jsp");
		}
			
		else
		{
			
			
			
			
			
			
			resp.sendRedirect("UserDashBoard.jsp");
		}
			
	
		
		
		
	}
	

}
