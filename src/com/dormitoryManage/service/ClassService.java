package com.dormitoryManage.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.dormitoryManage.dao.AnnounceDAO;
import com.dormitoryManage.dao.ClassesDAO;
import com.dormitoryManage.domain.Announcement;
import com.dormitoryManage.domain.Classes;

public class ClassService {
	
	static String getGrade(String arg){
		if(arg.equals("")){
			return arg;
		}else{
			Date date = new Date();
//			System.out.println(date.getYear() + 1900);
//			System.out.println(date.getMonth() + 1);
			if(date.getMonth()>=8){
				return date.getYear() + 1900 - Integer.parseInt(arg) + 1 + "";
			}else{
				return date.getYear() + 1900 - Integer.parseInt(arg) + "";
			}
		}
		
	}

	public List<Classes> search(String arg) throws SQLException {
		// TODO Auto-generated method stub
		ClassesDAO classesDao = new ClassesDAO();
		List<Classes> list = classesDao.search(getGrade(arg));
		return list;
	}

	public List<Classes> sear(String key, String arg) throws SQLException {
		// TODO Auto-generated method stub
		ClassesDAO classesDao = new ClassesDAO();
		List<Classes> list = classesDao.sear(key,getGrade(arg));
		return list;
	}

}
