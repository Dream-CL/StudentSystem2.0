package com.cl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.cl.dao.JDBCUtility.*;

public class QueryIdAndUmber {
	
	/**
	 * 	查询学号或身份证号是否存在
	 * @param id
	 * @param umber
	 * @return
	 */
	public static boolean queryIdAndUmber(String id,String umber) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean flag = true;
		String sql = null;
		
		try {
			Class.forName(jdbc_Driver);
			conn = DriverManager.getConnection(mysql_URL, user, password);
			sql = "select * from student_info where id='"+id+"' or umber='"+umber+"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				flag = false;
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtility.Close(rs, ps, conn);
		}
		return flag;
	}
}
