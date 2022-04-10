package com.flyaway;

import java.beans.Statement;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.sun.corba.se.pept.transport.Connection;

/**
 * Servlet implementation class InsertFlight
 */
public class InsertFlight extends HttpServlet {
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertFlight() {
        super();
        // TODO Auto-generated constructor stub
    }
   


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LocalDate d=LocalDate.now();
		String source=request.getParameter("from");
		String to=request.getParameter("to");
		String departure=request.getParameter("departure");
		String time=request.getParameter("time");
		String price=request.getParameter("price");
		String airline=request.getParameter("airline");
		char[] temp=new char[7];
		char c=source.charAt(0);
		temp[0]=c;
		c=to.charAt(0);
		temp[1]=c;
		c=price.charAt(0);
		temp[2]=c;
		c=time.charAt(0);
		temp[3]=c;
		c=time.charAt(3);
		temp[4]=c;
		c=time.charAt(4);
		temp[5]=c;
		c=airline.charAt(0);
		temp[6]=c;
		Flight f=new Flight();
		f.setSource(source);;
		f.setDestination(to);
		f.setJourneyday(departure);
		f.setClock(time);
		f.setPrice(price);
		f.setAirline(airline);
		
		String s=toString(temp);
		f.setTicket(s);
		AnnotationConfiguration conf=new AnnotationConfiguration();
		System.out.println("all");
		SessionFactory sf=conf.configure("hibernate1.cfg.xml").buildSessionFactory();
		System.out.println("apple");
		Session se=sf.openSession();
		org.hibernate.Transaction tr= se.beginTransaction();
		se.save(f);
		tr.commit();
		response.sendRedirect("Addedflightsucess.html");
		
	}


public static String toString(char[] a)
{
    // Creating object of String class
    String string = new String(a);

    return string;
}
}