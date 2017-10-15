package com.book.action;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.opensymphony.xwork2.ActionSupport;

import database.DatabaseConnection;


/*
 * 查询详细信息
 */
public class Show_information extends ActionSupport {

	private static final long serialVersionUID = -8918002507472684675L;
	
	private String ISBN;
	private String Title;
	private String Publisher;
	private Date PublishDate;
	private double Price;
	
	
	
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public Date getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(Date publishDate) {
		PublishDate = publishDate;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}




	private int AuthorID;
	private String Name;
	private int Age;
	private String Country;
	
	public int getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}

	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	
	
	
		public String execute() throws Exception {
		
		
		 Connection conn;	//connection对象conn代表与数据库的链接
		 Statement stmt;	//statement对象stmt用于将SQL语句发送到数据库中
		 ResultSet rs;		//保存符合SQL语句的所有行数据
		
				 
		 //查询书
		try
		{
			 conn=DatabaseConnection.getConnection();	
			 stmt=conn.createStatement();				
			 String sql=" select *from book where ISBN='"+ISBN+"' ";		//SQL语句
			 rs=stmt.executeQuery(sql);					//	执行查询，返回所有符合条件的语句
			 
			while (rs.next())
			{	 
				setISBN(rs.getString("ISBN"));
				setTitle(rs.getString("Title"));
				setAuthorID(rs.getInt("AuthorID"));
				setPublisher(rs.getString("Publisher"));
				setPublishDate(rs.getDate("PublishDate"));
				setPrice(rs.getDouble("Price"));
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	   		
		 //作者信息查询
		 try
		 {
			 conn=DatabaseConnection.getConnection();	
			 stmt=conn.createStatement();				
			 String sql="select *from author where AuthorID='"+getAuthorID()+"'";		
			 rs=stmt.executeQuery(sql);			
				 
				while (rs.next())
				{
				setAuthorID(rs.getInt("AuthorID"));
				setName(rs.getString("Name"));
				setAge(rs.getInt("Age"));
				setCountry(rs.getString("Country"));
				}

		 } catch (SQLException e)
		 {
			e.printStackTrace();
		 }
		 
		// TODO 自动生成的方法存根
		return super.execute();
	}
	
}
