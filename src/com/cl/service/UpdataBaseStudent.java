package com.cl.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cl.dao.UpdataStudentDao;

@WebServlet("/UpdataBaseStudent")
public class UpdataBaseStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdataBaseStudent() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String a = request.getParameter("age");
		int age = Integer.parseInt(a);
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		java.sql.Date birth = java.sql.Date.valueOf(request.getParameter("birth"));
		UpdataStudentDao.updataStudent(id, name, age, sex, phone, birth);
		PrintWriter pw = response.getWriter();
		String json = "{\"win\":\"修改成功\"}";
		pw.print(json);
		pw.flush();
		pw.close();
	}
}
