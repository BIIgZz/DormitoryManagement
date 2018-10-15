package com.dormitoryManage.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dormitoryManage.domain.College;
import com.dormitoryManage.domain.Student;
import com.dormitoryManage.service.DiscributionService;

import net.sf.json.JSONObject;

public class CountCollegeNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String tip;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String collegeId = request.getParameter("collegeId");
		DiscributionService service = new DiscributionService();
		List<Student> colleges = service.getStudentsInCol(collegeId);
		int girls=0;
		int boys=0;
		for (Student student : colleges) {
			if(student.getSex().equals("b")) {
				if(student.getStatus().equals("0"))
				boys++;
			}else {
				if(student.getStatus().equals("0"))
				girls++;
			}
		}
		response.setCharacterEncoding("utf-8");
		if(!colleges.isEmpty())
		 tip=colleges.get(0).getCollegeName()+"共"+colleges.size()+"人，男生"+boys+"人未分配，女生"+girls+"人未分配";
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulate("tips1", tip);
		response.getWriter().print(jsonObject);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
