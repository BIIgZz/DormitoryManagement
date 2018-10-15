package com.dormitoryManage.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.dormitoryManage.dbutils.DataSourceUtils;
import com.dormitoryManage.domain.Apartment;
import com.dormitoryManage.domain.Bedroom;
import com.dormitoryManage.domain.Classes;
import com.dormitoryManage.domain.College;
import com.dormitoryManage.domain.DisByStudent;
import com.dormitoryManage.domain.EmpByStudent;
import com.dormitoryManage.domain.Manager;
import com.dormitoryManage.domain.Pending;
import com.dormitoryManage.domain.Student;

public class DiscributionDao {

	public List<College> getCollegeList() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from college";
		List<College> colleges=queryRunner.query(sql, new BeanListHandler<College>(College.class));
		return colleges;
	}

	public List<Classes> getClasses(String collegeId) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from classes where collegeId=?";
		List<Classes> classes=queryRunner.query(sql, new BeanListHandler<Classes>(Classes.class),collegeId);
		return classes;
	}

	public List<Long> getPending(String classId) throws SQLException {
		// TODO 自动生成的方法存根
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		List<Long> countNum = new ArrayList<>();
		String sql="select count(*) from student where classId=? and status=0";
		Long num = (Long) queryRunner.query(sql, new ScalarHandler(),classId);
		countNum.add(num);
		sql = "select count(*) from student where classId=? and status=0 and sex = 'g'";
		Long girls = (Long) queryRunner.query(sql, new ScalarHandler(),classId);
		countNum.add(girls);
		sql = "select count(*) from student where classId=? and status=0 and sex = 'b'";
		Long boys = 	(Long) queryRunner.query(sql, new ScalarHandler(),classId);
		countNum.add(boys);
		
		return countNum;
	}

	public List<Apartment> getApartment(String sex) throws SQLException {
		// TODO 自动生成的方法存根
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from apartment where sex=?";
		List<Apartment> apartments = queryRunner.query(sql, new BeanListHandler<Apartment>(Apartment.class),sex);
		
		return apartments;
	}

	public List<Student> getStudents(String classId) throws SQLException {
		// TODO 自动生成的方法存根
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from student where classId=?";
		List<Student> students=queryRunner.query(sql, new BeanListHandler<Student>(Student.class),classId);
		return students;
	}

	public List<Bedroom> getBedrooms(String apmId) throws SQLException {
		// TODO 自动生成的方法存根
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from bedroom where apartmentId=? and totalbed>0";
		List<Bedroom> bedrooms = queryRunner.query(sql, new BeanListHandler<Bedroom>(Bedroom.class),apmId);
		return bedrooms;
	}
	public List<Bedroom> getFreeBedrooms(String apmId) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from bedroom where apartmentId=? and totalBed>0";
		List<Bedroom> bedrooms = queryRunner.query(sql, new BeanListHandler<Bedroom>(Bedroom.class),apmId);
		return bedrooms;
	}

	public Student getStudent(String studentId) throws SQLException {
		// TODO 自动生成的方法存根
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from student where studentid=?";
		Student student = queryRunner.query(sql, new BeanHandler<Student>(Student.class),studentId);
		
		return student;
	}

	public void setDiscribed(List<Student> discribed) throws SQLException {
		// TODO 自动生成的方法存根
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update student set status=1, bedroomId=?, bedroomName=? where  studentNo=?";
//		for (Student student : discribed) {
//			queryRunner.update(sql,student.getBedroomId(),student.getBedroomName(),student.getStudentNo());
//		}
		Student student =null;
		for (int i = 0; i < discribed.size(); i++) {
			student=discribed.get(i);
			queryRunner.update(sql,student.getBedroomId(),student.getBedroomName(),student.getStudentNo());
		}
		
	} 

	public void setTotalBeds(List<Bedroom> bedrooms) throws SQLException {
		// TODO 自动生成的方法存根
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update bedroom set totalBed=? where  bedroomId=?";
		for (Bedroom bedroom : bedrooms) {
			queryRunner.update(sql,bedroom.getTotalBed(),bedroom.getBedroomId());
		}
	}

	public void setStudentRoom(DisByStudent disByStudent) throws SQLException {
		// TODO 自动生成的方法存根
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update student set status=1 , bedroomId=?,bedroomName=(select bedroomName from bedroom "
				+ "where bedroomId=?) where studentId=?";
		queryRunner.update(sql,disByStudent.getBedroomId(),disByStudent.getBedroomId(),disByStudent.getStuId());
		
	}

	public void setRoomStatus(DisByStudent disByStudent) throws SQLException {
		// TODO 自动生成的方法存根
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update bedroom set totalbed=totalbed-1 where bedroomId=?";
		queryRunner.update(sql,disByStudent.getBedroomId());
	}

	public List<Student> getStudentIncol(String collegeId) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from student where collegeid=?";
		List<Student> students = queryRunner.query(sql, new BeanListHandler<Student>(Student.class),collegeId);
		return students;
	}

	public List<Manager> getManagerList() throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from manager";
		List<Manager> managers=queryRunner.query(sql, new BeanListHandler<Manager>(Manager.class));
		
		return managers;
	}


}
