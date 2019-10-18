package com.cl.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cl.dao.QueryStudentDao;
import com.cl.model.Student;

@WebServlet("/UpdataStudent2.0")
public class UpdataStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdataStudent() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		Student stu = QueryStudentDao.queryStudent(id);
		PrintWriter pw = response.getWriter();
		String JSON = "{\"id\":\""+stu.getId()+"\",\"name\":\""+stu.getName()+"\",\"age\":\""+stu.getAge()+"\",\"sex\":\""+stu.getSex()+"\",\"phone\":\""+stu.getPhone()+"\",\"birth\":\""+stu.getBirth()+"\",\"major\":\""+stu.getmajor()+"\",\"number\":\""+stu.getumber()+"\"}";
		pw.print(JSON);
		pw.flush();
		pw.close();
	}
}
