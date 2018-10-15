package com.dormitoryManage.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.dormitoryManage.dao.AnnounceDAO;
import com.dormitoryManage.dao.VisitorDAO;
import com.dormitoryManage.domain.Announcement;
import com.dormitoryManage.domain.Visitor;

public class VisitorService {
	static public String getDate(String flag){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		if(flag.equals("")){
			return flag;
		}else{
			int numOfDate = Integer.parseInt(flag);
			c.add(Calendar.DATE, 0 - numOfDate);
			Date d = c.getTime();
			String day = sdf.format(d);
			return day;
		}
	}
	
	
	public Visitor create(String visitorName, String visitorCall, String visitorSex, String bedroomName,
			String reason) throws SQLException {
		// TODO Auto-generated method stub
		Visitor visitor = new Visitor(visitorName, visitorCall, visitorSex, bedroomName, reason);
		VisitorDAO visitorDao = new VisitorDAO();
		visitorDao.create(visitor);
		return visitor;
	}

	public List<Visitor> search(String date, String bedroom) throws SQLException {
		// TODO Auto-generated method stub
		VisitorDAO visitorDao = new VisitorDAO();
		List<Visitor> list = visitorDao.search(getDate(date),bedroom);
		return list;
	}

	public List<Visitor> search() throws SQLException {
		// TODO Auto-generated method stub
		VisitorDAO visitorDao = new VisitorDAO();
		List<Visitor> list = visitorDao.search();
		return list;
	}


	public List<Visitor> sear(String key, String arg) throws SQLException {
		// TODO Auto-generated method stub
		VisitorDAO visitorDao = new VisitorDAO();
		List<Visitor> list = visitorDao.sear(key,arg);
		return list;
	}


	public Visitor get(String visitorId) throws SQLException {
		// TODO Auto-generated method stub
		VisitorDAO visitorDao = new VisitorDAO();
		Visitor visitor = visitorDao.get(visitorId);
		return visitor;
	}


	public void update(String visitorId, String visitorName, String visitorCall, String visitorSex, String bedroomName,
			String reason) throws SQLException {
		// TODO Auto-generated method stub
		VisitorDAO visitorDao = new VisitorDAO();
		visitorDao.update(visitorId, visitorName, visitorCall, visitorSex, bedroomName, reason);
	}


	public void delete(String visitorId) throws SQLException {
		// TODO Auto-generated method stub
		VisitorDAO visitorDao = new VisitorDAO();
		visitorDao.delete(visitorId);
	}


	public List<Visitor> searchAll() throws SQLException {
		// TODO Auto-generated method stub
		VisitorDAO visitorDao = new VisitorDAO();
		List<Visitor> list = visitorDao.searchAll();
		return list;
	}


	public void delete(List<String> key) throws SQLException {
		// TODO Auto-generated method stub
		VisitorDAO visitorDao = new VisitorDAO();
		for (String string : key) {
			visitorDao.delete(string);
		}
		
	}

}
