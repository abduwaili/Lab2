package com.book.action;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import java.sql.PreparedStatement;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import database.DatabaseConnection;

public class DeleteAction extends ActionSupport {
	private static final long serialVersionUID = 12609042809506920L;

	Map<String, Object> session;
    
	private String isbn;
	
	Connection conn;	
	Statement stmt;	

	public String execute() throws Exception
	{
		
		ActionContext context=ActionContext.getContext();
		session=context.getSession();
		isbn=(String) session.get("Delete");
	
		//根据INSB号删除书信息
		try
		 {
			 conn=DatabaseConnection.getConnection();	
			 stmt=conn.createStatement();				
			 String sql=" delete from book where ISBN=?";//'"+insb+"' ";		//SQL语句
			 PreparedStatement pStatement=conn.prepareStatement(sql);
			 pStatement.setString(1,isbn );
			 pStatement.executeUpdate();
			 
			 pStatement.close();
			 conn.close();
			 stmt.close();
			 session.remove("Delete");
		} catch (SQLException e)
		{
			e.printStackTrace();
		 }
				 
		return "success";
	}

}
