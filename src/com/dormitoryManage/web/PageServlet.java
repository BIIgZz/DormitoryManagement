package com.dormitoryManage.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dormitoryManage.domain.Manager;
import com.dormitoryManage.domain.Page;
import com.dormitoryManage.service.DiscributionService;
import com.dormitoryManage.service.ManagerService;

public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		DiscributionService discributionService = new DiscributionService();
//		List<Manager> managers=discributionService.getManagerList();
//		request.setAttribute("dataList", managers);
//		
//		String pageNo = request.getParameter("pageNo");
//		if (pageNo==null) {
//			pageNo="1";
//		}
//		int PageNow=Integer.parseInt(pageNo);
//		int pageTotal=1;
//		Page<Manager> page=null;
//		try {
//		 page = ManagerService.fingPage(PageNow,pageTotal);
//		} catch (SQLException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		request.setAttribute("page", page);
//		request.getRequestDispatcher("/pages/man/list.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
