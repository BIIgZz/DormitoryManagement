package com.dormitoryManage.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.dormitoryManage.domain.DisByClass;
import com.dormitoryManage.service.DiscributionService;

public class TodisbyClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			DisByClass byClass = new DisByClass();
			request.setCharacterEncoding("utf-8");
			try {
				BeanUtils.populate(byClass, request.getParameterMap());
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			DiscributionService discributionService = new DiscributionService();
			try {
				discributionService.disByClass(byClass);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			response.getWriter().print("<html><head><style>*{padding: 0;margin: 0;}html, body, body > div{ width: 100%; height: 100%;} div { text-align: center; padding: 100px; box-sizing: border-box; color: green; font-size: 100px;}</style></head><body><div>successful</div></body></html>");

			
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
