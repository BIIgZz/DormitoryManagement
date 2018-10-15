package com.dormitoryManage.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.dormitoryManage.domain.DisByStudent;
import com.dormitoryManage.service.DiscributionService;

public class DisbystuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			DisByStudent disByStudent = new DisByStudent();
			try {
				BeanUtils.populate(disByStudent, request.getParameterMap());
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			DiscributionService service = new DiscributionService();
			service.setStudent(disByStudent);
			response.getWriter().print("<html><head><style>*{padding: 0;margin: 0;}html, body, body > div{ width: 100%; height: 100%;} div { text-align: center; padding: 100px; box-sizing: border-box; color: green; font-size: 100px;}</style></head><body><div>successful</div></body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
