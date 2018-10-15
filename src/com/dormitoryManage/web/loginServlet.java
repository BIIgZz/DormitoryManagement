package com.dormitoryManage.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dormitoryManage.dao.BedroomDAO;
import com.dormitoryManage.domain.College;
import com.dormitoryManage.domain.Student;
import com.dormitoryManage.domain.User;
import com.dormitoryManage.service.DiscributionService;
import com.dormitoryManage.service.RootService;

public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
//		BedroomDAO.add();
		RootService rootService = new RootService();
		User user = new User();
		DiscributionService discributionService = new DiscributionService();
		List<College> collegeList = new ArrayList();
		try {
			collegeList=discributionService.getCollegeList();
			user=rootService.login(name,password);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		if(user==null ){
			PrintWriter out=response.getWriter();
			String url=request.getContextPath()+"/pages/basic/login.jsp";
			out.print("<script language='javascript'>alert('登录失败');window.location.href='"+url+"';</script>");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("collegeList", collegeList);
			switch(user.getType()){
			case "student": 
				Student stu = null;
				try {
					stu = RootService.GetStudent(user.getName());
					session.setAttribute("stu", stu);
					
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				break;
			case "root":
				
				break;
			default :
				
				break;
			}
			
			
			response.sendRedirect(request.getContextPath()+"/pages/index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
