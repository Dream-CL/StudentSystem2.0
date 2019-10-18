package com.cl.dao;

import static com.cl.dao.JDBCUtility.jdbc_Driver;
import static com.cl.dao.JDBCUtility.mysql_URL;
import static com.cl.dao.JDBCUtility.password;
import static com.cl.dao.JDBCUtility.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cl.model.Student;

/**
 * 	取出全部的学生信息.dao
 * @author 24829
 *
 */
public class userAll {
	
	/**
	 * 	返回一个List集合包含所有学生的详细信息
	 * @return List<Student> list
	 */
	public static List<Student> getAll(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student stu = null;
		List<Student> list = new ArrayList<>();
		
		try {
			Class.forName(jdbc_Driver);
			conn = DriverManager.getConnection(mysql_URL, user, password);
			String sql = "select * from student_info";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				String phone = rs.getString("phone");
				java.sql.Date birth = rs.getDate("birth");
				String umber = rs.getString("umber");
				String major = rs.getString("major");
				stu = new Student(id, name, birth, age, sex, phone, umber, major);
				list.add(stu);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtility.Close(rs, ps, conn);
		}
		return list;
	}
}
