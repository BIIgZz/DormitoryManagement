package com.dormitoryManage.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dormitoryManage.dbutils.DataSourceUtils;
import com.dormitoryManage.domain.Classes;
import com.dormitoryManage.domain.Student;
import com.dormitoryManage.domain.Visitor;

public class StudentDAO {

	public List<Student> search(String status, String college, String grade, String sex) throws SQLException {
		// TODO Auto-generated method stub
		String statusCondition = " status = '" + status + "' ";
		String collegeCondition = " collegeId = '" + college + "' ";
		String gradeCondition = " grade = " + grade + " ";
		String sexCondition = " sex = '" + sex + "' "; 
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String condition = "";
		boolean flag = false;
		if(status!=null){
			condition += statusCondition;
			flag = true;
		}if(!college.equals("")){
			if(flag){
				condition += " and ";
			}
			condition += collegeCondition;
		}if(!grade.equals("")){
			if(flag){
				condition += " and ";
				flag = true;
			}
			condition += gradeCondition;
		}if(sex!=null){
			if(flag){
				condition += " and ";
				flag = true;
			}
			condition += sexCondition;
		}
		String sql = "select * from student where " + condition + " order by studentId";
		List<Student> list = queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
		return list;
	}

	public List<Student> sear(String key) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql =null;
		if(key==null){
			sql = "select * from  student order by studentId";
		}else{
			sql = "select * from  student where studentName like '%" + key + "%' or className like '%" + key + "%' or collegeName like '%" + key + "%' or bedroomName like '%" + key + "%' order by studentId";
		}
		List<Student> list = queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
		return list;
	}

}
