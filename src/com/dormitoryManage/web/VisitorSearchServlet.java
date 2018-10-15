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
 * Servlet implementation class VisitorSearchServlet
 */
public class VisitorSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitorSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * 公告管理 -> 按条件查询
		 */
		request.setCharacterEncoding("UTF-8");
		String date = request.getParameter("date");
		String bedroom = request.getParameter("bedroom");
		VisitorService visitorService = new VisitorService();
		try {
			List<Visitor> list = visitorService.search(date,bedroom);
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
