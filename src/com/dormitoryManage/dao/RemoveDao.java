package com.dormitoryManage.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dormitoryManage.dbutils.DataSourceUtils;
import com.dormitoryManage.domain.EmpByStudent;
import com.dormitoryManage.domain.Student;

public class RemoveDao {

	public void removeStudent(EmpByStudent student) throws SQLException {
		// TODO 自动生成的方法存根
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql;
		sql="select * from student where studentid=?";
		Student student2=queryRunner.query(sql, new BeanHandler<Student>(Student.class),student.getStudentId());
		 sql="update student set status=0 ,bedroomId=' ',bedroomName=' ' where studentid=?";
		queryRunner.update(sql,student.getStudentId());
		sql="update bedroom set totalbed=totalbed+1 where bedroomId=?";
		queryRunner.update(sql,student2.getBedroomId());
		
	}

	public void removeByClass(String classId) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql;
		sql="select * from student where classid=?";
		List<Student> students = queryRunner.query(sql, new BeanListHandler<Student>(Student.class),classId);
		sql="update student set status=0 ,bedroomid=NULL ,bedroomname=NULL where classid=?";
		queryRunner.update(sql,classId);
		sql="update bedroom set totalbed=totalbed+1 where totalbed<4 and bedroomid=? ";
		for (Student student : students) {
			queryRunner.update(sql,student.getBedroomId());
		}
		System.out.println(students.get(students.size()-1).getBedroomId());
		queryRunner.update(sql,students.get(students.size()-1).getBedroomId());
		
		
	}

}
