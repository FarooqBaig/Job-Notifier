package com.registeration;
import com.scraping.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 * Servlet implementation class List
 */

public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Scrape scrape = new Scrape();
		ArrayList<Posts> allJobs = new ArrayList<Posts>();
		int noOfPages=3,count = 1;
		for(int i=0;i<noOfPages;i++)
		{
         count = scrape.AllJobs(i,count,allJobs);
		}
		
		String  cname = request.getParameter("cname");
		String  rname = request.getParameter("rname");
		String  lname = request.getParameter("lname");
		String  fname = request.getParameter("fname");
		 RequestDispatcher dispatcher = null;
		 request.setAttribute("data",allJobs);
		 dispatcher = request.getRequestDispatcher("results.jsp");
		 
		 dispatcher.forward(request, response);
		
		
		
		
		
	}

}
