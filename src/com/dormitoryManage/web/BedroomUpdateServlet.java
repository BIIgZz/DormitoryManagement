package com.dormitoryManage.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dormitoryManage.domain.Announcement;
import com.dormitoryManage.domain.Bedroom;
import com.dormitoryManage.service.AnnounceService;
import com.dormitoryManage.service.BedroomService;

/**
 * Servlet implementation class BedroomUpdateServlet
 */
public class BedroomUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BedroomUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/**
		 * ËÞÉá¹ÜÀí -> ÐÞ¸Ä
		 */
		request.setCharacterEncoding("UTF-8");
		String bedroomId = request.getParameter("brId");
		Bedroom bedroom = null;
		BedroomService bedroomService = new BedroomService();
		try {
			bedroom = bedroomService.get(bedroomId);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("obj", bedroom);
		request.getRequestDispatcher("./pages/br/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
