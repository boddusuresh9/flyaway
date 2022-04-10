package com.flyaway;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class changepass
 */
public class changepass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String userName,password,url,driver;
	Connection con;
	Statement st;
	PreparedStatement pst;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changepass() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	userName="root";
		password="Suresh@1997";
		url="jdbc:mysql://localhost:3306/nam";
		driver="com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(driver);
			con= DriverManager.getConnection(url,userName,password);
			st=(Statement) con.createStatement();
			pst=con.prepareStatement("update admin set pass=? where email=?");

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
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		if(email=="admin@gmail.com") {
			try {
				pst.setString(1,email);
				pst.setString(2,password);
				pst.executeUpdate();
				response.sendRedirect("adminsucess.html");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
