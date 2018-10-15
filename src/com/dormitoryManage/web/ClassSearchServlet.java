package com.dormitoryManage.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dormitoryManage.domain.Announcement;
import com.dormitoryManage.domain.Classes;
import com.dormitoryManage.service.AnnounceService;
import com.dormitoryManage.service.ClassService;

/**
 * Servlet implementation class ClassSearchServlet
 */
public class ClassSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 班级管理 -> 按条件查询
		 */
		request.setCharacterEncoding("UTF-8");
		String arg = request.getParameter("date");
		ClassService classService = new ClassService();
		try {
			List<Classes> list = classService.search(arg);
			request.setAttribute("dataList", list);
			request.getRequestDispatcher("./pages/cla/list.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
