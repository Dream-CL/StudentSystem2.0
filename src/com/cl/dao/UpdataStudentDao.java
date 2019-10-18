package com.cl.dao;

import static com.cl.dao.JDBCUtility.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdataStudentDao {
	
	public static void updataStudent(String id,String name,int age,String sex,String phone,java.sql.Date birth) {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(jdbc_Driver);
			conn = DriverManager.getConnection(mysql_URL, user, password);
			String sql = "update student_info set name='"+name+"' , age='"+age+"' , sex='"+sex+"' , phone='"+phone+"' , birth='"+birth+"' where id='"+id+"'";
			ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtility.Close(ps, conn);
		}
	}
}
