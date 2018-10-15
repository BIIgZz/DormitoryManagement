package com.dormitoryManage.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dormitoryManage.service.ManagerService;

public class UpdateManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String managerName=request.getParameter("managerName");
		String managerCall=request.getParameter("managerCall");
		String managerId=request.getParameter("managerId");
		ManagerService managerService = new ManagerService();
		managerService.updateManager(managerName,managerCall,managerId);
		response.setCharacterEncoding("utf-8");
		response.sendRedirect("managerList");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
