package com.cl.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cl.dao.AddStudentDao;
import com.cl.dao.QueryIdAndUmber;

/**
 * 	添加学生信息
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent2.0")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddStudent() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		//接收数据
		String id = request.getParameter("id");
		String number = request.getParameter("number");
		boolean flag = QueryIdAndUmber.queryIdAndUmber(id, number);
		if(!flag) {
			String error = "{\"false\":\"学号或身份证号已存在\"}";
			pw.print(error);
			pw.flush();
		}else {
			String name = request.getParameter("name");
			String a = request.getParameter("age");
			int age = Integer.parseInt(a);
			String sex = request.getParameter("sex");
			String phone = request.getParameter("phone");
			java.sql.Date birth = java.sql.Date.valueOf(request.getParameter("birth"));
			String major = request.getParameter("major");
			AddStudentDao.addInfo(id, name, age, sex, phone, birth, number, major);
			String win = "{\"true\":\"添加成功\"}";
			pw.print(win);
			pw.flush();
		}
		pw.close();
	}
}
