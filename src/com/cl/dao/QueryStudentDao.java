package com.cl.dao;

import static com.cl.dao.JDBCUtility.jdbc_Driver;
import static com.cl.dao.JDBCUtility.mysql_URL;
import static com.cl.dao.JDBCUtility.password;
import static com.cl.dao.JDBCUtility.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cl.model.Student;

public class QueryStudentDao {

	public static Student queryStudent(String id) {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student stu = null;
		
		try {
			Class.forName(jdbc_Driver);
			conn = DriverManager.getConnection(mysql_URL, user, password);
			String sql = "select * from student_info where id='"+id+"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String ids = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				String phone = rs.getString("phone");
				java.sql.Date birth = rs.getDate("birth");
				String umber = rs.getString("umber");
				String major = rs.getString("major");
				stu = new Student(ids, name, birth, age, sex, phone, umber, major);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtility.Close(rs, ps, conn);
		}
		return stu;
	}
}
