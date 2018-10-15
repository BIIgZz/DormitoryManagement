package com.dormitoryManage.service;

import java.sql.SQLException;

import com.dormitoryManage.dao.DiscributionDao;
import com.dormitoryManage.dao.RemoveDao;
import com.dormitoryManage.domain.EmpByStudent;

public class RemoveService {

	public void removeStudent(EmpByStudent student) {
		RemoveDao dao = new RemoveDao();
		try {
			dao.removeStudent(student);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public void removeByClass(String classId)  {
		// TODO 自动生成的方法存根
		RemoveDao dao = new RemoveDao();
		try {
			dao.removeByClass(classId);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
