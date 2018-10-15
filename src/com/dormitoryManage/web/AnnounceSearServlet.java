package com.dormitoryManage.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dormitoryManage.domain.Announcement;
import com.dormitoryManage.service.AnnounceService;

/**
 * Servlet implementation class AnnounceSearServlet
 */
public class AnnounceSearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnnounceSearServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 公告管理 -> 搜索
		 */
		request.setCharacterEncoding("UTF-8");
		String key = request.getParameter("key");
		String arg = request.getParameter("date");
		AnnounceService announceService = new AnnounceService();
		try {
			List<Announcement> list = announceService.sear(key,arg);
			request.setAttribute("dataList", list);
			request.getRequestDispatcher("./pages/anno/list.jsp").forward(request, response);
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
