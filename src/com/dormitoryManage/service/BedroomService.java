package com.dormitoryManage.service;

import java.sql.SQLException;
import java.util.List;

import com.dormitoryManage.dao.AnnounceDAO;
import com.dormitoryManage.dao.BedroomDAO;
import com.dormitoryManage.domain.Announcement;
import com.dormitoryManage.domain.Bedroom;

public class BedroomService {

	public Bedroom create(String apartmentId, String floor, String bedroomName, String totalBed) throws SQLException {
		// TODO Auto-generated method stub
		Bedroom bedroom = new Bedroom(apartmentId, bedroomName, totalBed);
		BedroomDAO bedroomDao = new BedroomDAO();
		bedroomDao.create(bedroom);
		return bedroom;
	}

	public List<Bedroom> search(String flag) throws SQLException {
		// TODO Auto-generated method stub
		BedroomDAO bedroomDao = new BedroomDAO();
		List<Bedroom> list = bedroomDao.search(flag);
		return list;
	}

	public List<Bedroom> sear(String key, String arg) throws SQLException {
		// TODO Auto-generated method stub
		BedroomDAO bedroomDao = new BedroomDAO();
		List<Bedroom> list = bedroomDao.sear(key,arg);
		return list;
	}

	public Bedroom get(String bedroomId) throws SQLException {
		// TODO Auto-generated method stub
		BedroomDAO bedroomDao = new BedroomDAO();
		Bedroom bedroom = bedroomDao.get(bedroomId);
		return bedroom;
	}

	public void update(String bedroomId, String bedroomName, String totalBed) throws SQLException {
		// TODO Auto-generated method stub
		BedroomDAO bedroomDao = new BedroomDAO();
		bedroomDao.update(bedroomId, bedroomName, totalBed);
	}

}
