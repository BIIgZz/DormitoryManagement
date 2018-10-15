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
 * Servlet implementation class ClassSearServlet
 */
public class ClassSearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassSearServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * °à¼¶¹ÜÀí -> ËÑË÷
		 */
		request.setCharacterEncoding("UTF-8");
		String key = request.getParameter("key");
		String arg = request.getParameter("date");
//		System.out.println(arg);
		ClassService classService = new ClassService();
		try {
			List<Classes> list = classService.sear(key,arg);
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
