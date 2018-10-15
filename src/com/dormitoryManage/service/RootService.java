package com.dormitoryManage.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.catalina.ssi.SSIServletRequestUtil;

import com.dormitoryManage.dao.LoginDao;
import com.dormitoryManage.dao.StudentInfoDao;
import com.dormitoryManage.domain.Announcement;
import com.dormitoryManage.domain.Student;
import com.dormitoryManage.domain.User;
import com.dormitoryManage.domain.Visitor;


public class RootService {

	public User login(String name, String password) throws SQLException {
		// TODO �Զ����ɵķ������
		LoginDao loginDao = new LoginDao();
		User user =loginDao.login(name,password);
		return user;
	}
	
//	//New User
//	public static NewUser GetNewUser(String id,String psd) throws SQLException{
//		return LoginDao.GetNewUser(id, psd);
//	}
//	
	//��ȡ����
	public static Announcement GetAnno() throws Exception{
		Announcement anno=StudentInfoDao.GetAnno();
		return anno;
	}
	
	//��ȡѧ��������Ϣ
	public  static Student GetStudent(String id) throws SQLException{
		Student stu=StudentInfoDao.GetStudent(id);
		return stu;
	}
	
	
	//��ȡ����
	public static List<Student> GetRoomMates(String num,String id) throws SQLException{
		List<Student> stu=StudentInfoDao.GetRoomMates(num, id);
		return stu.isEmpty()?null:stu;
	}
	
	//��ȡ�༶ͬѧ
	public static List<Student> GetClassmates(String className) throws SQLException{
		return StudentInfoDao.GetClassMates(className);
	}
	
	//��ȡ�ι���
	public static List<Visitor> GetVisitors(String roomNum) throws SQLException{
		List<Visitor> vs= StudentInfoDao.GetVisitors(roomNum);
		return vs;
	}
	
	//��������
		public static boolean ChangePsd(String id,String psd) throws SQLException{
			User user=StudentInfoDao.GetNewUser(id);
			if(user!=null){
				if(user.getPassword().equals(psd))
					return false;
				return StudentInfoDao.ChangePsd(id, psd);
			}
			return false;
		}
}
