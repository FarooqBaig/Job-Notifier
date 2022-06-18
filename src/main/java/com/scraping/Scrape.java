package com.scraping;
import com.registeration.Posts;
import java.io.IOException;
import java.util.*;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scrape {

	public int  AllJobs(int ele,int count,ArrayList<Posts> allJobs, boolean preferred , String rname)
	{

		  try {
        		  
			  String url="https://www.linkedin.com/jobs/search/?keywords=tech&location=new%20york&position=1&pageNum=";
			  url=url+ele;
			 // System.out.println(url+" "+ele);
			  Document doc = Jsoup.connect(url).get();  
   
			  Elements ul=doc.select("ul.jobs-search__results-list");
            Elements li = ul.select("li");
                      
            //Solution 1  - Accessing Single Element
            
            String src=li.eq(0).select("img.artdeco-entity-image").attr("data-delayed-url");
    	      String src2=li.eq(0).select("img.artdeco-entity-image").attr("data-ghost-url");    	           	    
    	      String href= li.eq(0).select(".base-card__full-link").attr("href");              
           /*       	      
    	      System.out.println("src : " + src);          	        	    
    	      System.out.println("src2 : " + src2);            	    
    	      System.out.println("href : " + href ); 
    	   */           
            // Solution 2  - Accessing Every Element using loop
    	      int i=1;
            for (Element item : li) {  
                      	           	    
          	    String JobTitle= item.getElementsByClass("base-search-card__title").text();
          	    
          	    //Please note : LinkedIn used data-delayed-url & data-ghost-url instead of src attribute 
          	    String ImgSrc1=item.select("img.artdeco-entity-image").attr("data-delayed-url");
          	    String ImgSrc2=item.select("img.artdeco-entity-image").attr("data-ghost-url");
          	           	    
          	    String hyperLink= item.select(".base-card__full-link").attr("href");
          	    
          	  /*  System.out.println("Job : " + count); 
          	    System.out.println("Title : " + JobTitle);          	        	    
          	    System.out.println("Img Src 1 : " + ImgSrc1);  
          	    System.out.println("Img Src 1 : " + ImgSrc2);          	    
          	    System.out.println("Href : " + hyperLink );   
          	    System.out.println("");
              */
          	    if(JobTitle.equals(rname) && preferred == true)
          	    allJobs.add(new Posts(count,JobTitle,ImgSrc1,ImgSrc2,hyperLink)); 
          	    else
          	    allJobs.add(new Posts(count,JobTitle,ImgSrc1,ImgSrc2,hyperLink)); 
          	   count++;
          	} 
                                            	          	     	      
        } catch (IOException e) {
            e.printStackTrace();
        }
		  return count;
	}

}