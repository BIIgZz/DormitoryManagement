package com.dormitoryManage.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dormitoryManage.domain.Visitor;
import com.dormitoryManage.service.VisitorService;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class GetBedroomServlet
 */
public class GetBedroomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBedroomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			// TODO Auto-generated method stub
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("utf-8");
			VisitorService visitorService = new VisitorService();
			try {
				List<Visitor> list = visitorService.search();
				response.getWriter().print(JSONArray.fromObject(list).toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
