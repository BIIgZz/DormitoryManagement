package com.dormitoryManage.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dormitoryManage.domain.Student;
import com.dormitoryManage.service.RootService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class classmatesServlet
 */
public class classmatesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json; charset=utf-8");
		String className=request.getParameter("className");
		try{
		   List<Student> stus=RootService.GetClassmates(className);
		   response.getWriter().print(JSONArray.fromObject(stus).toString());
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
