package com.dormitoryManage.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dormitoryManage.domain.Student;
import com.dormitoryManage.service.RootService;

import net.sf.json.JSONObject;


public class stuInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/json; charset=utf-8");
		String k=request.getParameter("h");
		try{
			HttpSession session=request.getSession();
			Student stu=RootService.GetStudent(k);
			response.getWriter().print(JSONObject.fromObject(stu).toString());
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
