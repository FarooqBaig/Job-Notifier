package com.registeration;

public class Posts {
private int SNO;
private String JobTitle;
private String img1;
private String img2;
private String link;
public Posts(int a , String b, String c , String d, String e)
{
	this.SNO = a;
	this.JobTitle = b;
	this.img1=c;
	this.img2=d;
	this.link=e;
}
public String getSNO() { return ""+SNO ;}
public String getJobTitle() { return JobTitle ;}
public String getimg1() { return img1 ;}
public String getimg2() { return img2 ;}
public String getlink() { return link ;}
}
