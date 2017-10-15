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
 * �����������ֲ�ѯ��Ϣ
 * @author ����
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
	
		 Connection conn;	//connection����conn���������ݿ������
		 Statement stmt;	//statement����stmt���ڽ�SQL��䷢�͵����ݿ���
		 ResultSet rs;		//�������SQL��������������
		 
		 ActionContext context=ActionContext.getContext();
		 session=context.getSession();
		 session.put("authorname", AuthorName);
		 
		 //������Ϣ��ѯ
		 Vector<AuthorInfirmation>authorvec=new Vector<>();	
		 try
		 {
			 conn=DatabaseConnection.getConnection();	//��ȡ���Ӷ���conn
			 stmt=conn.createStatement();				//	����һ��stmt����
			 String sql="select *from author where Name='"+AuthorName+"'";		//SQL���
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
		 } catch (Exception e)
		 {
			e.printStackTrace();
		 }
		 
		 
		 //�����Ϣ��ѯ
		 Map<BookInfirmation, AuthorInfirmation>book_author=new HashMap<>();
		 for(int i=0;i<authorvec.size();i++)
		 {
			 try
			 {
				 int id=authorvec.get(i).getAuthorID();//��ȡ����
				 conn=DatabaseConnection.getConnection();	
				 stmt=conn.createStatement();				
				 String sql=" select *from book where AuthorID='"+id+"' ";		//SQL���
				 rs=stmt.executeQuery(sql);					//	ִ�в�ѯ���������з������������

				 while(rs.next())
				 {
					 BookInfirmation bookInf=new BookInfirmation();
					 
					 bookInf.setISBN(rs.getString("ISBN"));
					 bookInf.setTitle(rs.getString("Title"));
					 bookInf.setAuthorID(rs.getInt("AuthorID"));
					 bookInf.setPublisher(rs.getString("Publisher"));
					 bookInf.setPublishDate(rs.getDate("PublishDate"));
					 bookInf.setPrice(rs.getDouble("Price"));
					 
					 book_author.put(bookInf,authorvec.get(i));//ÿ�������������ӳ��
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
