package com.dormitoryManage.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dormitoryManage.dbutils.DataSourceUtils;
import com.dormitoryManage.domain.Announcement;
import com.dormitoryManage.domain.Classes;

public class ClassesDAO {

	public List<Classes> search(String grade) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from classes where grade = " + grade + " order by classId";
		List<Classes> list = queryRunner.query(sql, new BeanListHandler<Classes>(Classes.class));
		return list;
	}

	public List<Classes> sear(String key, String arg) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = null;
		if(arg.equals("")){
			sql = "select * from classes where className like '%" + key + "%' order by classId";
		}else{
			sql = "select * from classes where grade = " + arg + " and className like '%" + key + "%' order by classId";
		}
		
		List<Classes> list = queryRunner.query(sql, new BeanListHandler<Classes>(Classes.class));
		return list;
	}


}
