package com.cl.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cl.dao.DeleteStudentDao;

@WebServlet("/DeleteStudent2.0")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteStudent() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		DeleteStudentDao.delete(id);
		PrintWriter pw = response.getWriter();
		String JSON = "{\"win\":\""+id+"删除成功\"}";
		pw.print(JSON);
		pw.flush();
		pw.close();
	}

}
