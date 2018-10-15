package com.dormitoryManage.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dormitoryManage.domain.Announcement;
import com.dormitoryManage.domain.Visitor;
import com.dormitoryManage.service.AnnounceService;
import com.dormitoryManage.service.VisitorService;

/**
 * Servlet implementation class VisitorSearServlet
 */
public class VisitorSearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitorSearServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * ·Ã¿Í¹ÜÀí -> ËÑË÷
		 */
		request.setCharacterEncoding("UTF-8");
		String key = request.getParameter("key");
		String arg = request.getParameter("date");
		VisitorService visitorService = new VisitorService();
		try {
			List<Visitor> list = visitorService.sear(key,arg);
			request.setAttribute("dataList", list);
			request.getRequestDispatcher("./pages/visit/list.jsp").forward(request, response);
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
