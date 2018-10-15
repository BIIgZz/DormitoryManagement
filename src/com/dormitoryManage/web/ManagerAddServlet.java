package com.dormitoryManage.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.dormitoryManage.domain.ManagerAdd;
import com.dormitoryManage.service.ManagerService;

public class ManagerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ManagerService managerService = new ManagerService();
		response.setCharacterEncoding("utf-8");
		ManagerAdd add = new ManagerAdd();
		try {
			BeanUtils.populate(add, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		managerService.addManager(add);
		response.sendRedirect("managerList");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
