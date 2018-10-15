package com.dormitoryManage.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.dormitoryManage.dao.AnnounceDAO;
import com.dormitoryManage.dao.StudentDAO;
import com.dormitoryManage.dao.VisitorDAO;
import com.dormitoryManage.domain.Announcement;
import com.dormitoryManage.domain.Student;
import com.dormitoryManage.domain.Visitor;

public class StudentService {

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
	
	public List<Student> search(String status, String college, String grade, String sex) throws SQLException {
		// TODO Auto-generated method stub
		StudentDAO studentDao = new StudentDAO();
		if(status!=null){
			if(status.equals("Y"))
				status = "1";
			else
				status = "0";
		}if(sex!=null){
			if(sex.equals("Ů"))
				sex = "g";
			else
				sex = "b";
		}
		List<Student> list = studentDao.search(status,college,getGrade(grade),sex);
		return list;
	}

	public List<Student> sear(String key) throws SQLException {
		// TODO Auto-generated method stub
		StudentDAO studentDao = new StudentDAO();
		List<Student> list = studentDao.sear(key);
		return list;
	}

	

}
