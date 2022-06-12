package com.registeration;

import jakarta.servlet.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  uname = request.getParameter("name");
		String  uemail = request.getParameter("email");
		String  upwd = request.getParameter("pass");
		String  umobile = request.getParameter("contact");
		RequestDispatcher dispatcher = null;
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/company?useSSL=false","root","Farooq@06");
		    PreparedStatement pst = con.prepareStatement("insert into users(uname,upwd,uemail,umobile) values(?,?,?,?)");
		    pst.setString(1, uname);
		    pst.setString(2, upwd );
		    pst.setString(3, uemail);
		    pst.setString(4, umobile);
		
		    int rowCount = pst.executeUpdate();
		    dispatcher = request.getRequestDispatcher("registration.jsp");
		    if(rowCount>0)
		    {
		    	request.setAttribute("status","success");	    	
		    }
		    else
		    {
		    	request.setAttribute("status","failed");	    		
		    }
		    dispatcher.forward(request, response);
		    
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
