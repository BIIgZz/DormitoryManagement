package com.dormitoryManage.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.dormitoryManage.domain.Visitor;
import com.dormitoryManage.service.RootService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class visitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/json; charset=utf-8");
		String k=request.getParameter("h");

		try{
			HttpSession session=request.getSession();
			List<Visitor> vis=RootService.GetVisitors(k);
			response.getWriter().print(JSONArray.fromObject(vis).toString());
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
