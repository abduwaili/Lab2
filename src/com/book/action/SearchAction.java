package com.book.action;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import database.DatabaseConnection;
import author_book_Information.*;


/**
 * 根据作者名字查询信息
 * @author 阿杜
 *
 */

public class SearchAction extends ActionSupport{

	private static final long serialVersionUID = 245806943515360614L;

	private String AuthorName;
	
	public String getAuthorName() {
		return AuthorName;
	}

	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}



	HttpServletRequest request = ServletActionContext.getRequest();
	Map<String, Object> session;


		
	
	public String execute() throws Exception {
	
		 Connection conn;	//connection对象conn代表与数据库的链接
		 Statement stmt;	//statement对象stmt用于将SQL语句发送到数据库中
		 ResultSet rs;		//保存符合SQL语句的所有行数据
		 
		 ActionContext context=ActionContext.getContext();
		 session=context.getSession();
		 session.put("authorname", AuthorName);
		 
		 //作者信息查询
		 Vector<AuthorInfirmation>authorvec=new Vector<>();	
		 try
		 {
			 conn=DatabaseConnection.getConnection();	//获取链接对象conn
			 stmt=conn.createStatement();				//	创建一个stmt对象
			 String sql="select *from author where Name='"+AuthorName+"'";		//SQL语句
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
		 } catch (Exception e)
		 {
			e.printStackTrace();
		 }
		 
		 
		 //书的信息查询
		 Map<BookInfirmation, AuthorInfirmation>book_author=new HashMap<>();
		 for(int i=0;i<authorvec.size();i++)
		 {
			 try
			 {
				 int id=authorvec.get(i).getAuthorID();//获取作者
				 conn=DatabaseConnection.getConnection();	
				 stmt=conn.createStatement();				
				 String sql=" select *from book where AuthorID='"+id+"' ";		//SQL语句
				 rs=stmt.executeQuery(sql);					//	执行查询，返回所有符合条件的语句

				 while(rs.next())
				 {
					 BookInfirmation bookInf=new BookInfirmation();
					 
					 bookInf.setISBN(rs.getString("ISBN"));
					 bookInf.setTitle(rs.getString("Title"));
					 bookInf.setAuthorID(rs.getInt("AuthorID"));
					 bookInf.setPublisher(rs.getString("Publisher"));
					 bookInf.setPublishDate(rs.getDate("PublishDate"));
					 bookInf.setPrice(rs.getDouble("Price"));
					 
					 book_author.put(bookInf,authorvec.get(i));//每本书与作者配对映射
				 }
				 //request.setAttribute("book_author", book_author);
				session.put("book_author", book_author);
				
				
			 } catch (Exception e)
			 {
				e.printStackTrace();
			 }
		 }
		 
		 if(authorvec.isEmpty())
		 {
			 return "error";
		 }
		 else 
		 {
			 return "success";
		 }
		
    }

}
