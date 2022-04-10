package com.flyaway;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class CreateAccount
 */
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("in servlet");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String mobileno=request.getParameter("mobilenumber");
		
		if(!verifyEmail(email)) {
			response.sendRedirect("ErrorCreateAccount.html");
		}
		if(!verifyLastName(firstname)) {
			response.sendRedirect("ErrorCreateAccount.html");
		}
		if(!verifyLastName(lastname)) {
			response.sendRedirect("ErrorCreateAccount.html");
		}
		if(!verifymbl(mobileno)) {
			response.sendRedirect("ErrorCreateAccount.html");
		}
		
		
		
		
	User uc=new User();
		uc.setFirstName(firstname);
		uc.setLastName(lastname);
		uc.setEmail(email);
		uc.setPassword(password);
		uc.setMobileNo(mobileno);
		uc.setTicket(null);
		
		AnnotationConfiguration conf=new AnnotationConfiguration();
		System.out.println("all");
		SessionFactory sf=conf.configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println("apple");
		Session se=sf.openSession();
		org.hibernate.Transaction tr= se.beginTransaction();
		se.save(uc);
		tr.commit();
		response.sendRedirect("adminsucess.html");
	 
	}
	private boolean verifymbl(String lname)
	{
	    lname = lname.trim();

	    if(lname == null || lname.equals(""))
	        return false;

	    if(!lname.matches("[0-9]*"))
	        return false;

	    return true;
	}
	private boolean verifyLastName(String lname)
	{
	    lname = lname.trim();

	    if(lname == null || lname.equals(""))
	        return false;

	    if(!lname.matches("[a-zA-Z]*"))
	        return false;

	    return true;
	}
	private boolean verifyEmail(String email)
	{
	    email = email.trim();

	    if(email == null || email.equals(""))
	        return false;

	    if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
	        return false;

	    return true;
	}

}
