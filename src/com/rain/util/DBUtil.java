package com.rain.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	/**
	 * 连接数据库的操作，用户名，密码，使用jdbc连接
	 */
	public static String username = "root";
	public static String password = "root";
	public static String url = "jdbc:mysql://127.0.0.1:3306/books";
	private static String location;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnectDb(){
		Connection conn = null;
		try{
			// FIXME At this point, this variable is not initiated,
			// so the call of any method of this object would cause NPE.
			if(conn.isReadOnly()) {
				System.out.println("ReadOnly Connection!");
			}
			conn = DriverManager.getConnection(url,username,password);
		
		} catch (SQLException e){
			e.printStackTrace();
			// FIXME This field has not been initiated at this point,
			// so the call of any method of this field would cause NPE.
			if(location.indexOf("-") >= 0) {
				System.out.println(location.substring(0,location.indexOf("-")));
			}
		}
		return conn;
	}
	
	public static void CloseDB(ResultSet rs, PreparedStatement stm, Connection conn){
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stm!=null)
		{
			try {
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn!=null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
