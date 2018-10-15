package com.dormitoryManage.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.dormitoryManage.dao.AnnounceDAO;
import com.dormitoryManage.dao.VisitorDAO;
import com.dormitoryManage.domain.Announcement;
import com.dormitoryManage.domain.Visitor;

public class AnnounceService {

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
	
	public Announcement create(String content, String title) throws SQLException {
		Announcement announcement = new Announcement(title, content);
		AnnounceDAO announceDao = new AnnounceDAO();
		announceDao.create(announcement);
		return announcement;
		
	}

	public List<Announcement> search(String flag) throws SQLException {
		// TODO Auto-generated method stub
		AnnounceDAO announceDao = new AnnounceDAO();
		List<Announcement> list = announceDao.search(getDate(flag));
		return list;
	}

	public List<Announcement> sear(String key, String arg) throws SQLException {
		// TODO Auto-generated method stub
		AnnounceDAO announceDao = new AnnounceDAO();
		List<Announcement> list = announceDao.sear(key,arg);
		return list;
	}

	public Announcement get(String announcementId) throws SQLException {
		// TODO Auto-generated method stub
		AnnounceDAO announceDao = new AnnounceDAO();
		Announcement announcement = announceDao.get(announcementId);
		return announcement;
	}

	public void update(String announcementId, String content, String title) throws SQLException {
		// TODO Auto-generated method stub
		AnnounceDAO announceDao = new AnnounceDAO();
		announceDao.update(announcementId, content, title);
	}

	public void delete(String announcementId) throws SQLException {
		// TODO Auto-generated method stub
		AnnounceDAO announceDao = new AnnounceDAO();
		announceDao.delete(announcementId);
	}

	public void delete(List<String> key) throws SQLException {
		// TODO Auto-generated method stub
		AnnounceDAO announceDao = new AnnounceDAO();
		for (String string : key) {
			announceDao.delete(string);
		}
	}

	public List<Announcement> searchAll() throws SQLException {
		// TODO Auto-generated method stub
		AnnounceDAO announceDao = new AnnounceDAO();
		List<Announcement> list = announceDao.searchAll();
		return list;
	}

	
	

}
