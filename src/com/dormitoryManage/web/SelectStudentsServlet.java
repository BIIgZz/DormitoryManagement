package com.dormitoryManage.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dormitoryManage.domain.Student;
import com.dormitoryManage.service.DiscributionService;

import net.sf.json.JSONArray;

public class SelectStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String classId = request.getParameter("classId");
		DiscributionService discributionService = new DiscributionService();
		List<Student> students =discributionService.getStudents(classId);
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(JSONArray.fromObject(students).toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
