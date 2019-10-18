package com.cl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * JDBC工具类.dao
 * @author 24829
 *
 */
public class JDBCUtility {
	static final String jdbc_Driver = "com.mysql.jdbc.Driver";
	//jdbc驱动
	static final String mysql_URL = "jdbc:mysql://localhost/studentsystem";
	//mysql地址
	static final String user = "root";
	//用户名
	static final String password = "123456";
	//密码
	
	/**
	 * 	关闭JDBC三个流
	 * @param rs
	 * @param ps
	 * @param conn
	 */
	public static void Close(ResultSet rs,PreparedStatement ps,Connection conn) {
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(ps!=null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 	关闭JDBC两个流
	 * @param ps
	 * @param conn
	 */
	public static void Close(PreparedStatement ps,Connection conn) {
		try {
			if(ps!=null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(conn!=null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
