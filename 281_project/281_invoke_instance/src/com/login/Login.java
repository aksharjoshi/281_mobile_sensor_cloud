package com.login;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.instance.*;

public class Login extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		DBConnect db = new DBConnect();
		db.conect();
		String query = "Select username,password from user_details_tbl";
		ResultSet rs = db.execute(query);
		HttpSession session = req.getSession();
		
		RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
		RequestDispatcher rd1 = req.getRequestDispatcher("UserDashBoard.jsp");
	
		String Username=req.getParameter("Username");

		String Password=req.getParameter("Password");
		

	
		if (Username.equals("admin@admin.com") && Password.equals("admin"))
		{
			resp.sendRedirect("AdminDashboard.jsp");
		}
			
		else
		{
		
			try {
				
				while(rs.next()){				
					
					if((rs.getString("username").equals(req.getParameter("Username"))) && (rs.getString("password").equals(req.getParameter("Password")))){
						
						req.setAttribute("Username", rs.getString("username"));
						session.setAttribute("Username",rs.getString("username"));
						rd1.forward(req, resp);
						break;
					}
					
					else{
						
						req.setAttribute("alertm","Wrong Username or Password");
						req.setAttribute("count",1);
						
						rd.forward(req, resp);
						
						break;
					}
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
			
	
		
		
		
	}
	

}
