package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ��������MySQL���ݿ⣬����һ��Connection����
 * @author ����
 *
 */
public class DatabaseConnection {

	static Connection conn=null;
	public static Connection getConnection()
	{
				
			//���������ݿ�����
			String driver = "com.mysql.jdbc.Driver";
			String username = "root";
			String password = "WAILI520guzal";
			String dbUrl = String.format("jdbc:mysql://%s:%s/%s", "twdhphfusbrx.mysql.sae.sina.com.cn", "10211", "bookdb");
			try {
				Class.forName(driver).newInstance();
			    conn = DriverManager.getConnection(dbUrl, username, password);
			    
			  //�������ݿ�����
				/*Class.forName("com.mysql.jdbc.Driver").newInstance();
			   	String url="jdbc:mysql://localhost:3306/bookdb";
				conn=DriverManager.getConnection(url, "root", "WAILI520guzal");*/	
			} catch (Exception e) {
			   e.printStackTrace();
			}
			return conn;//������������Connection����
	}
}