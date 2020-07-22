package dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.Useritem;
import db.DBUtil;
import sun.security.util.Password;

import java.util.ArrayList;
import java.util.regex.*;
public class userdao {


	private static Connection connection;
	private static Statement stmt; 
	private static String CHECKSQL = "\\b(and|exec|insert|select|drop|grant|alter|delete|update|count|chr|mid|master|truncate|char|declare|or)\\b|(\\*|;|\\+|'|%)";
	public static int islogin(Useritem user,int flag)
	{
		ResultSet rs=null;
		stmt=null;
		connection=null;
		PreparedStatement prep=null;
		try {
			connection=DBUtil.getConn();
			String name=user.getUserName();
			String password=user.getPassword();
			String sql=null;
			if(flag==2) {
				name=name.replaceAll("or", "");
				name=name.replaceAll("and", "");
				password=password.replaceAll("or", "");
				password=password.replaceAll("and", "");
				sql="select * from logintable where username='"+ name+"' and password='"+password+"'";
				stmt=connection.createStatement(); 
				rs=stmt.executeQuery(sql);
			}else if(flag==3) {
				name=name.replaceAll("or", "");
				name=name.replaceAll("Or", "");
				name=name.replaceAll("oR", "");
				name=name.replaceAll("OR", "");
				name=name.replaceAll("and", "");
				name=name.replaceAll("/*", "");
				name=name.replaceAll("--", "");
				password=password.replaceAll("or", "");
				password=password.replaceAll("and", "");
				sql="select * from logintable where username='"+ name+"' and password='"+password+"'";
				stmt=connection.createStatement(); 
				rs=stmt.executeQuery(sql);
			}else if(flag==4) {
				sql="select * from logintable where username= ? and password= ?";
				prep=connection.prepareStatement(sql);
				prep.setString(1, name);
				prep.setString(2,password);
				rs=prep.executeQuery();
			}else if(flag==6) {
				Pattern pattern = Pattern.compile(CHECKSQL);
				Matcher matcher = pattern.matcher(name);
				Matcher matcher1 = pattern.matcher(password);
				if (matcher.find()||matcher1.find())
				{
					return 2;
				}
				System.out.print(flag);
				sql="select * from logintable where username='"+ name+"' and password='"+password+"'";
				stmt=connection.createStatement(); 
				rs=stmt.executeQuery(sql);
			}else {
				sql="select * from logintable where username='"+ name+"' and password='"+password+"'";
				stmt=connection.createStatement(); 
				rs=stmt.executeQuery(sql);
			}
			while(rs!=null&&rs.next()) {
				user.setPassword(rs.getString("password"));
				user.setUserName(rs.getString("username"));
				return 1;
			}
		
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close();
			try {
				if(rs!=null)
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return 0;
	}
	public static List<Useritem> searchInfo(String info) throws ClassNotFoundException, SQLException {
		ArrayList<Useritem> lst=new ArrayList<>();
		ResultSet rs=null;
		stmt=null;
		connection=null;
		PreparedStatement prep=null;
		
			connection=DBUtil.getConn();
			String sql="select * from logintable where majorNo= "+ info+"";
				stmt=connection.createStatement(); 
			
				rs=stmt.executeQuery(sql);
			
			while(rs!=null&&rs.next()) {
				Useritem temp=new Useritem();
				temp.setRealname(rs.getString(4));
				temp.setMajor(rs.getString(5));
				lst.add(temp);
			}
			if(!lst.isEmpty())
			return lst;

		
		return null;
	}
	
}
