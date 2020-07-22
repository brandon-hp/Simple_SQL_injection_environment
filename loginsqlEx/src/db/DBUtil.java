package db;

import java.beans.Statement;
import java.io.Closeable;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBUtil {
	private static String driver="org.sqlite.JDBC";
	//数据库路径
	private static String URL="jdbc:sqlite://d:/login.db";
	private static Connection conn;
	private static java.sql.Statement stmt=null;
	public static Connection getConn()throws ClassNotFoundException,SQLException{
		try {
			 Class.forName(driver);
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			conn=DriverManager.getConnection(URL);
			stmt=conn.createStatement();
			System.out.print("连接数据库成功");
			return conn;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public static void close() {
		try {
			if(stmt!=null)
			stmt.close();
			if(conn!=null)
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

}
