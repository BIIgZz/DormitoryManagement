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
 * Servlet implementation class bedroomServlet
 */
public class bedroomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json; charset=utf-8");
		String num=request.getParameter("bedNum");
		String id=request.getParameter("stuId");
		
		try{
			List<Student> stu=RootService.GetRoomMates(num, id);
			response.getWriter().print(JSONArray.fromObject(stu).toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
