package com.dormitoryManage.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.dormitoryManage.domain.Manager;
import com.dormitoryManage.service.DiscributionService;

import net.sf.json.JSONArray;

public class ManagerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiscributionService discributionService = new DiscributionService();
		List<Manager> managers=discributionService.getManagerList();
		request.setAttribute("dataList", managers);
	
		request.getRequestDispatcher("/pages/man/list.jsp").forward(request, response);
//		response.getWriter().print(JSONArray.fromObject(managers).toString());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
