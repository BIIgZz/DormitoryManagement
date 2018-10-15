package com.dormitoryManage.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dormitoryManage.domain.Classes;
import com.dormitoryManage.service.DiscributionService;

import net.sf.json.JSONArray;

public class SelectClassServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				String collegeId =request.getParameter("collegeId");
				DiscributionService discributionService = new DiscributionService();
				List<Classes> classes = null;
				try {
					classes = discributionService.getClassList(collegeId);
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				response.setContentType("text/html;charset=UTF-8");
				
				response.getWriter().print(JSONArray.fromObject(classes).toString());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
