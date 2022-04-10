package com.flyaway;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class booksession
 */
public class booksession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String userName,password,url,driver;
	Connection con;
	Statement st;
	PreparedStatement pst;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public booksession() {
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
			pst=con.prepareStatement("INSERT INTO link_user_flight VALUES(?,?,?)");

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
		HttpSession session=req.getSession();
		String mail=(String) session.getAttribute("email");
		String source=req.getParameter("from");
		String to=req.getParameter("to");
		String departure=req.getParameter("departure");
		String time=req.getParameter("time");
		String price=req.getParameter("price");
		String ticket=req.getParameter("ticket");
		String airline=req.getParameter("airline");
		String passengers=req.getParameter("passengers");
		String TIC="Select * from flight where source='"+source+"'and destination='"+to+"' and clock='"+time+"' and journeyday='"+departure+"'and price='"+price+"' and ticket='"+ticket+"' and airline='"+airline+"'";
		//and destination='"+to+"' and clock='"+time+"' and journeyday='"+departure+"'and price='"+price+"' "
		
		try {
			
			ResultSet rs=((java.sql.Statement) st).executeQuery(TIC);
			
			//System.out.println(rs.getString("ticket"));
			if(rs.next()) {
				
				pst.setString(1,mail);
				pst.setString(2,ticket);
				pst.setString(3, passengers);;
				pst.executeUpdate();
				resp.sendRedirect("details.html");
				
				
			
			}
			else {
				resp.getWriter().write("<h1>No Flight available</h1>");
				resp.getWriter().write("<a href=user2.jsp>back</a>");
				
			}
			}catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	}
	}
}
