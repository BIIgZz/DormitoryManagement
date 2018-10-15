package com.dormitoryManage.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dormitoryManage.domain.Visitor;
import com.dormitoryManage.service.VisitorService;

/**
 * Servlet implementation class VisitorAddServlet
 */
public class VisitorAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisitorAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				/**
				 * 访客管理 -> 来访登记
				 */
				request.setCharacterEncoding("UTF-8");
				String visitorName = request.getParameter("visitorName");
				String visitorCall = request.getParameter("visitorCall");
				String visitorSex = request.getParameter("visitorSex");
				String bedroomName = request.getParameter("bedroomName");
				String reason = request.getParameter("reason");
				VisitorService visitorService = new VisitorService();
				try {
					Visitor visitor = visitorService.create(visitorName, visitorCall, visitorSex, bedroomName, reason);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.setContentType("text/html;charset=utf-8");
				request.setCharacterEncoding("utf-8");
				response.sendRedirect("./pages/visit/list.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
