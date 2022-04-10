package com.flyaway;


import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
//import com.sun.corba.se.pept.transport.Connection;

/**
 * Servlet implementation class UserValidation
 */
public class UserValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String userName,password,url,driver;
	Connection con;
	Statement st;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserValidation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		userName="root";
		password="Suresh@1997";
		url="jdbc:mysql://localhost:3306/nam";
		driver="com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(url,userName,password);
			st=(Statement) con.createStatement();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String SELECT_QUERY="select Email from user where email='"+email+"'";
		String SELECT_QU="select password from user where password='"+password+"'";
		try {
			ResultSet rs=((java.sql.Statement) st).executeQuery(SELECT_QUERY);
			if(rs.next()) {
				ResultSet r=((java.sql.Statement) st).executeQuery(SELECT_QU);
				if(r.next()) {
					HttpSession session=req.getSession();
					session.setAttribute("email",email);
					resp.sendRedirect("user2.jsp");
					
				}
				
				
				
			}
			else {
					resp.sendRedirect("ErrorCreateAccount.html");
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
	
}

