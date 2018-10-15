package com.dormitoryManage.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dormitoryManage.domain.Student;
import com.dormitoryManage.service.DiscributionService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SelectStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentId = request.getParameter("studentId");
		DiscributionService service = new DiscributionService();
		Student student=service.getStudent(studentId);
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(JSONObject.fromObject(student).toString());
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
