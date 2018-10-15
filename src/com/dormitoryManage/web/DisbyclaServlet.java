package com.dormitoryManage.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.dormitoryManage.dao.BedroomDAO;
import com.dormitoryManage.domain.College;
import com.dormitoryManage.service.DiscributionService;

public class DisbyclaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DiscributionService discributionService = new DiscributionService();
		List<College> collegeList = new ArrayList();
		try {
			collegeList=discributionService.getCollegeList();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		request.setAttribute("collegeList", collegeList);
		HttpSession session = request.getSession();
		session.setAttribute("collegeList", collegeList);
		
		response.getWriter().print("<html><head><style>*{padding: 0;margin: 0;}html, body, body > div{ width: 100%; height: 100%;} div { text-align: center; padding: 100px; box-sizing: border-box; color: green; font-size: 100px;}</style></head><body><div>successful</div></body></html>");
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
