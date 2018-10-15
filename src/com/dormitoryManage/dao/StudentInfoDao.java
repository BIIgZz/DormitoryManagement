package com.dormitoryManage.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dormitoryManage.dbutils.DataSourceUtils;
import com.dormitoryManage.domain.Announcement;
import com.dormitoryManage.domain.Student;
import com.dormitoryManage.domain.User;
import com.dormitoryManage.domain.Visitor;

public class StudentInfoDao {
	//��ȡ�ι���
	public static List<Visitor> GetVisitors(String roomNum) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from visitor where bedroomName=?;";
		//select * from announcement  BY limit 1;";
		List<Visitor> vis=queryRunner.query(sql, new BeanListHandler<Visitor>(Visitor.class),roomNum);
		return vis;
	}
	
	//��ȡ������Ϣ
	public static Student GetStudent(String id) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from student where studentNo=?";
		Student stu = queryRunner.query(sql, new BeanHandler<Student>(Student.class),id);
		return stu;
	}

	//��ȡ����
	public static List<Student> GetRoomMates(String num,String id) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from student where bedroomName=? and studentId!=? ;";
		List<Student> stus=queryRunner.query(sql, new BeanListHandler<Student>(Student.class),num,id);
		return stus;
	}
	
	// ��ȡͬ��ͬѧ
	public static List<Student> GetClassMates(String className) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from student where classId=?;";
		List<Student> stus=queryRunner.query(sql, new BeanListHandler<Student>(Student.class),className);
		return stus;
	}
	
	//��ȡ������Ϣ
	public static Announcement GetAnno() throws Exception{
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from announcement ORDER BY createTime desc limit 1;";
		//select * from announcement  BY limit 1;";
		Announcement anno=queryRunner.query(sql, new BeanHandler<Announcement>(Announcement.class));
		return anno;
		}

	public static User GetNewUser(String id) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from user where name=?";
		User user=queryRunner.query(sql, new BeanHandler<User>(User.class),id);
		return user;
	}

	//������Ϣ
	public static boolean ChangePsd(String id,String psd) throws SQLException{
		
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="update user set password=? where name=?;";
		int isOk= queryRunner.update(sql,psd,id);
		return isOk>0?true:false;
	}
	
}
