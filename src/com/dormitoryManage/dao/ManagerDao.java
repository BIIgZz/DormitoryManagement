package com.dormitoryManage.dao;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dormitoryManage.dbutils.DataSourceUtils;
import com.dormitoryManage.domain.Manager;
import com.dormitoryManage.domain.ManagerAdd;
import com.dormitoryManage.domain.Student;

public class ManagerDao {
	public Manager getManager(String managerId) throws SQLException {
		// TODO 自动生成的方法存根
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from manager where managerid=?";
		Manager manager=queryRunner.query(sql, new BeanHandler<Manager>(Manager.class),managerId);
		return manager;
	}

	public void updateManager(String managerName, String managerCall, String managerId) throws SQLException {
		// TODO 自动生成的方法存根
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update manager set managerName=?,managerCall=? where managerId=?";
		queryRunner.update(sql,managerName,managerCall,managerId);
		
	}

	public int getTotal() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql ="select * from manager ";
		Long qLong= (Long) queryRunner.query(sql, new ScalarHandler());
				return qLong.intValue();
	}

	public List<Manager> findListForPage(int index, int pageTotal) throws SQLException {
		// TODO 自动生成的方法存根
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from Manager limit ?,?";
		return queryRunner.query(sql, new BeanListHandler<Manager>(Manager.class), index,pageTotal);
	}

	public void addManager(ManagerAdd add) throws SQLException {
		// TODO 自动生成的方法存根
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql;
		sql="select * from student where studentNo=?";
		Student student =queryRunner.query(sql, new BeanHandler<Student>(Student.class),add.getStuId());
		 sql = "insert into manager(managerid,managerName,managerPassword,managercall) values(?,?,?,?)";
		
		queryRunner.update(sql,student.getStudentNo(),student.getStudentName(),student.getStudentNo(),student.getStudentNo());
		
	}

	public void deleteManager(String managerId) throws SQLException {
		// TODO 自动生成的方法存根
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="delete from manager where managerId=?";
		queryRunner.update(sql,managerId);
	}

	public List<Manager> searchManager(String key) throws SQLException {
		// TODO 自动生成的方法存根
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from manager where managerName like '%"+key+"%' or managerCall Like '%"+key+"%'";
		
		return queryRunner.query(sql, new BeanListHandler<Manager>(Manager.class));
	}
}
