package com.cl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.cl.dao.JDBCUtility.*;

public class DeleteStudentDao {
	
	/**
	 * 删除学生信息
	 * @param id
	 */
	public static void delete(String id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			Class.forName(jdbc_Driver);
			conn = DriverManager.getConnection(mysql_URL, user, password);
			String sql = "delete from student_info where id='"+id+"'";
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
