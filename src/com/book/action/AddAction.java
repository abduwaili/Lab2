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
	
	
	
	//��������ͬ��������Ϣ
	public String search() throws Exception {
	
		Vector<AuthorInfirmation>authorvec=new Vector<>();	
		Connection conn;	
		Statement stmt;	
		ResultSet rs;		
		 ActionContext context=ActionContext.getContext();
		 session=context.getSession();

		 try
		 {
			 conn=DatabaseConnection.getConnection();	//��ȡ���Ӷ���conn
			 stmt=conn.createStatement();				//	����һ��stmt����
			 String sql="select *from author where Name='"+authorname+"'";		//SQL���
			 rs=stmt.executeQuery(sql);					//	ִ�в�ѯ���������з������������

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
	
	
	
		//���ߴ���ʱ���������ͼ�������
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
	
	
	
	
	//�����߲����ڣ����ͼ�������
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
			 //�������
			 conn=DatabaseConnection.getConnection();	
			 String sql="insert into author(Name,Age,Country)values(?,?,?)";
			 PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
			 ps.setString(1, authorname);
			 ps.setInt(2, age);
			 ps.setString(3, country);
			 ps.executeUpdate();
			 conn.close();
			 ps.close();
			 
			 //��ȡ����id
			 conn2=DatabaseConnection.getConnection();	//��ȡ���Ӷ���conn
			 stmt=conn2.createStatement();				//	����һ��stmt����
			 String sql2="select *from author where Name='"+authorname+"'";		//SQL���
			 rs=stmt.executeQuery(sql2);	
							//	ִ�в�ѯ���������з������������
			 while(rs.next())
			 {
				setId(rs.getInt("AuthorID"));
			 }
			 
		
			 //���ͼ��
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
