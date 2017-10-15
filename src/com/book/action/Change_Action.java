package com.book.action;

import java.sql.Connection;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;

import database.DatabaseConnection;
import sun.print.PSStreamPrintService;

public class Change_Action extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private String title;
	private String isbn;
	private String publisher;
	private Date publishdate;
	private double price;
	private  int id;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String execute() throws Exception {
		
		Connection conn;
		try {
			conn=DatabaseConnection.getConnection();	
			String sql="update book set Title=?,z,Publisher=?,PublishDate=?,Price=? where ISBN=?";
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setInt(2, id);
			ps.setString(3, publisher);
			ps.setDate(4, publishdate);
			ps.setDouble(5, price);
			ps.setString(6, isbn);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	
	

}
