package com.dormitoryManage.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dormitoryManage.domain.Announcement;
import com.dormitoryManage.domain.Visitor;
import com.dormitoryManage.service.AnnounceService;
import com.dormitoryManage.service.VisitorService;

/**
 * Servlet implementation class VisitorUpdateServlet
 */
public class VisitorUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitorUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 公告管理 -> 修改
		 */
		request.setCharacterEncoding("UTF-8");
		String visitorId = request.getParameter("visitorId");
		Visitor visitor = null;
		VisitorService visitorService = new VisitorService();
		try {
			visitor = visitorService.get(visitorId);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("obj", visitor);
		request.getRequestDispatcher("./pages/visit/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
