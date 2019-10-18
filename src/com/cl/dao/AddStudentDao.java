package com.cl.dao;

import static com.cl.dao.JDBCUtility.jdbc_Driver;
import static com.cl.dao.JDBCUtility.mysql_URL;
import static com.cl.dao.JDBCUtility.password;
import static com.cl.dao.JDBCUtility.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 	添加学生.dao
 * @author 24829
 *
 */
public class AddStudentDao {
	public static void addInfo(String id,String name,int age,String sex,String phone,java.sql.Date birth,String umber,String major){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(jdbc_Driver);
			conn = DriverManager.getConnection(mysql_URL, user, password);
			String sql = "insert into student_info values('"+id+"','"+name+"',"+age+",'"+sex+"','"+phone+"','"+birth+"','"+umber+"','"+major+"')";
			ps = conn.prepareStatement(sql);
			
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtility.Close(ps, conn);
		}
		
	}
}

