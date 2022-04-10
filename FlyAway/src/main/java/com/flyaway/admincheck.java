package com.flyaway;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class admincheck
 */
public class admincheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String userName,password,url,driver;
	Connection con;
	Statement st;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public admincheck() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		String SELECT_QUERY="select Email from Admin where email='"+email+"'";
		String SELECT_QU="select pass from Admin where pass='"+password+"'";
		try {
			ResultSet rs=((java.sql.Statement) st).executeQuery(SELECT_QUERY);
			System.out.println("in post");
			if(rs.next()) {
				ResultSet r=((java.sql.Statement) st).executeQuery(SELECT_QU);
				if(r.next()) {
					HttpSession session=request.getSession();
					session.setAttribute("email",email);
					response.sendRedirect("Adminhome.html");
					
				}			
			}
			else {
					response.sendRedirect("ErrorAdmin.html");
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}

	}
