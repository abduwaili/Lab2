package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 用于链接MySQL数据库，返回一个Connection对象
 * @author 阿杜
 *
 */
public class DatabaseConnection {

	static Connection conn=null;
	public static Connection getConnection()
	{
				
			//服务器数据库链接
			String driver = "com.mysql.jdbc.Driver";
			String username = "root";
			String password = "WAILI520guzal";
			String dbUrl = String.format("jdbc:mysql://%s:%s/%s", "twdhphfusbrx.mysql.sae.sina.com.cn", "10211", "bookdb");
			try {
				Class.forName(driver).newInstance();
			    conn = DriverManager.getConnection(dbUrl, username, password);
			    
			  //本地数据库链接
				/*Class.forName("com.mysql.jdbc.Driver").newInstance();
			   	String url="jdbc:mysql://localhost:3306/bookdb";
				conn=DriverManager.getConnection(url, "root", "WAILI520guzal");*/	
			} catch (Exception e) {
			   e.printStackTrace();
			}
			return conn;//返回数据链接Connection对象
	}
}