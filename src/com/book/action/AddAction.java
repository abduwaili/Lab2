package com.book.action;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;
import java.util.Vector;

import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import author_book_Information.AuthorInfirmation;
import database.DatabaseConnection;

public class AddAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	
	private String authorname;
	private int age;
	private String country;
	private String title;
	private String isbn;
	private String publisher;
	private Date publishdate;
	private double price;
	private  int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(Date publishdate) {
		this.publishdate = publishdate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthorname() {
		return authorname;
	}

	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}

	
	
	Map<String, Object> session;
	
	
	
	//返回所有同名作者信息
	public String search() throws Exception {
	
		Vector<AuthorInfirmation>authorvec=new Vector<>();	
		Connection conn;	
		Statement stmt;	
		ResultSet rs;		
		 ActionContext context=ActionContext.getContext();
		 session=context.getSession();

		 try
		 {
			 conn=DatabaseConnection.getConnection();	//获取链接对象conn
			 stmt=conn.createStatement();				//	创建一个stmt对象
			 String sql="select *from author where Name='"+authorname+"'";		//SQL语句
			 rs=stmt.executeQuery(sql);					//	执行查询，返回所有符合条件的语句

			 while(rs.next())
			 {
				 AuthorInfirmation authorInfirmation=new AuthorInfirmation();
				 authorInfirmation.setAuthorID(rs.getInt("AuthorID"));
				 authorInfirmation.setName(rs.getString("Name"));
				 authorInfirmation.setAge(rs.getInt("Age"));
				 authorInfirmation.setCountry(rs.getString("Country"));
				 authorvec.add(authorInfirmation);
			 }
			 session.put("authorinf", authorvec);
			 
		 } catch (Exception e)
		 {
			e.printStackTrace();
		 }
		  return "success";
	}
	
	
	
		//作者存在时，秩序添加图书和作者
		public String addbook() throws Exception {
			
			Connection conn1;				
			ActionContext context=ActionContext.getContext();
			session=context.getSession();
			int row=0;
			 try
			 {

				 conn1=DatabaseConnection.getConnection();
				 String sql1="insert into book(ISBN,Title,AuthorID,Publisher,PublishDate,Price)values(?,?,?,?,?,?)";
				 PreparedStatement ps1=(PreparedStatement) conn1.prepareStatement(sql1);
				 ps1.setString(1, isbn);
				 ps1.setString(2, title);
				 ps1.setInt(3, id);
				 ps1.setString(4, publisher);
				 ps1.setDate(5, publishdate);
				 ps1.setDouble(6, price);
				
				 row=ps1.executeUpdate();
				 conn1.close();
				 ps1.close();	 
			 } catch (Exception e)
			 {
				e.printStackTrace();
			 }
			 if(row==1)
			 {
				 return "success";
			 }
			 else {
				return "error";
			}
		
		}
	
	
	
	
	//若作者不存在，添加图书和作者
	public String execute() throws Exception {
		

		Connection conn;	
		Connection conn1;	
		Connection conn2;
		Statement stmt;
		ResultSet rs;
		
		ActionContext context=ActionContext.getContext();
		session=context.getSession();
		int row=0;
		 try
		 {
			 //添加作者
			 conn=DatabaseConnection.getConnection();	
			 String sql="insert into author(Name,Age,Country)values(?,?,?)";
			 PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
			 ps.setString(1, authorname);
			 ps.setInt(2, age);
			 ps.setString(3, country);
			 ps.executeUpdate();
			 conn.close();
			 ps.close();
			 
			 //获取作者id
			 conn2=DatabaseConnection.getConnection();	//获取链接对象conn
			 stmt=conn2.createStatement();				//	创建一个stmt对象
			 String sql2="select *from author where Name='"+authorname+"'";		//SQL语句
			 rs=stmt.executeQuery(sql2);	
							//	执行查询，返回所有符合条件的语句
			 while(rs.next())
			 {
				setId(rs.getInt("AuthorID"));
			 }
			 
		
			 //添加图书
			 conn1=DatabaseConnection.getConnection();
			 String sql1="insert into book(ISBN,Title,AuthorID,Publisher,PublishDate,Price)values(?,?,?,?,?,?)";
			 PreparedStatement ps1=(PreparedStatement) conn1.prepareStatement(sql1);
			 ps1.setString(1, isbn);
			 ps1.setString(2, title);
			 ps1.setInt(3, id);
			 ps1.setString(4, publisher);
			 ps1.setDate(5, publishdate);
			 ps1.setDouble(6, price);
			
			 row=ps1.executeUpdate();
			 conn1.close();
			 ps1.close();	 
		 } catch (Exception e)
		 {
			e.printStackTrace();
		 }
		 if(row!=0)
		 {
			 return "success";
		 }
		 else {
			return "error";
		}
	
	}
	

}
