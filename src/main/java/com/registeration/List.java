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
import java.util.Random;

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
		Random rand = new Random();
		ArrayList<Posts> allJobs = new ArrayList<Posts>();
		ArrayList<Posts> preferredJobs = new ArrayList<Posts>();
		int noOfPages=20,count = 1;
		boolean preferred=false;
		
		 String  cname = request.getParameter("cname");
		 String  rname = request.getParameter("rname");
		 String  lname = request.getParameter("lname");
		 String  fname = request.getParameter("fname");
		 int arr [] = new int[3];
		 for(int i=0;i<3;i++)
		 {
			 if(i==0)
				 arr[0]=rand.nextInt(15);
			 boolean checker = true ;
			 while(checker != true)
			 {
				 arr[i]=rand.nextInt(15);
				 if(i==1 && arr[i]!=arr[0] )
					 checker = false;
				 if(i==2 && arr[i]!=arr[0] &&arr[i]!=arr[1] )
					 checker = false;	 
			 }
		 }
		for(int i=0;i<3;i++)
		  count = scrape.AllJobs(arr[i],count,allJobs,preferred, rname);
		preferred = true ;
		count =1;
		for(int i=0;i<10;i++)
			count = scrape.AllJobs(i,count,preferredJobs,preferred, rname);
         
		
		
		
		 RequestDispatcher dispatcher = null;
		 request.setAttribute("data",allJobs);
		 request.setAttribute("data2",preferredJobs);
		 dispatcher = request.getRequestDispatcher("results.jsp");
		 
		 dispatcher.forward(request, response);
		
		
		
		
		
	}

}
