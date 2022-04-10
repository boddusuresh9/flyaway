package com.flyaway;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userdetails
 */
public class userdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String userName,password,url,driver;
	Connection con;
	Statement st;
	PreparedStatement pst;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userdetails() {
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
			pst=con.prepareStatement("insert into userdetails values(?,?,?)");

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
		String names=request.getParameter("name");
		String address=request.getParameter("add");
		String addhar=request.getParameter("adhar");
			try {
				pst.setString(1,names);
				pst.setString(2,address);
				pst.setString(3,addhar);
				pst.executeUpdate();
				response.getWriter().write("<h1>Sucess</h1>");
				response.sendRedirect("payment.html");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}
	}


