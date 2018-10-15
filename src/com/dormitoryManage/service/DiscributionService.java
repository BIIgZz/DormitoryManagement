package com.dormitoryManage.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dormitoryManage.dao.DiscributionDao;
import com.dormitoryManage.domain.Apartment;
import com.dormitoryManage.domain.Bedroom;
import com.dormitoryManage.domain.Classes;
import com.dormitoryManage.domain.College;
import com.dormitoryManage.domain.DisByClass;
import com.dormitoryManage.domain.DisByStudent;
import com.dormitoryManage.domain.EmpByStudent;
import com.dormitoryManage.domain.Manager;
import com.dormitoryManage.domain.Pending;
import com.dormitoryManage.domain.Student;

public class DiscributionService {

	private boolean remove;

	public List<College> getCollegeList() throws SQLException {
		DiscributionDao discributionDao = new DiscributionDao();
		List<College> colleges=discributionDao.getCollegeList();
		return colleges;
	}

	public List<Classes> getClassList(String collegeId) throws SQLException {
		DiscributionDao discributionDao = new DiscributionDao();
		List<Classes> classes =discributionDao.getClasses(collegeId);
		
		return classes;
	}

	public List<Long> getNum(String classId) throws SQLException {
		DiscributionDao discributionDao = new DiscributionDao();
		List<Long> Pengings =discributionDao.getPending(classId);
		return Pengings;
	}

	public List<Apartment> getApartments(String sex) throws SQLException {
		DiscributionDao discributionDao = new DiscributionDao();
		List<Apartment> apartments = discributionDao.getApartment(sex);
		return apartments;
	}

	public List<Student> getStudents(String classId) {
		DiscributionDao discributionDao = new DiscributionDao();
		List<Student> students = null;
		try {
			students = discributionDao.getStudents(classId);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return students;
	}

	public List<Bedroom> getBedrooms(String apmId) {
		// TODO �Զ����ɵķ������
		DiscributionDao discributionDao = new DiscributionDao();
		List<Bedroom> bedrooms = null;
		try {
			bedrooms = discributionDao.getBedrooms(apmId);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return bedrooms;
	}

	public Student getStudent(String studentId) {
		DiscributionDao discributionDao = new DiscributionDao();
		Student student = null;
		try {
			student = discributionDao.getStudent(studentId);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return student;
	}

	public void disByClass(DisByClass byClass) throws SQLException {
		// TODO �Զ����ɵķ������
		DiscributionDao discributionDao = new DiscributionDao();
		//ȡ��δ���������ͬѧ
			List<Student> students = discributionDao.getStudents(byClass.getClassId());
		//�ҳ�δ�����������ͬѧ
			List<Student> boys = new ArrayList<Student>();
			for (Student student : students) {
				if(student.getSex().equals("b")&&student.getStatus().equals("0")&&student.getClassId().equals(byClass.getClassId())) {
					boys.add(student);
				}
			}
		//�ҳ�δ���������Ůͬѧ
			List<Student> girls = new ArrayList<Student>();
			for (Student student : students) {
				if(student.getSex().equals("g")&&student.getStatus().equals("0")&&student.getClassId().equals(byClass.getClassId())) {
					girls.add(student);
				}
			}
		//�ҳ����е�����
		List<Bedroom> bedrooms = discributionDao.getFreeBedrooms(byClass.getApartmentId());
		List<Student> discribed = new ArrayList<>();
		
		//����ͬѧ�Ž�������
		int totalBedBoy=0;
			for (Bedroom bedroom : bedrooms) {
				totalBedBoy=Integer.parseInt(bedroom.getTotalBed());
				for (Student student : boys) {
					if(totalBedBoy==0)
						break;
					if(totalBedBoy>0 && student.getStatus().equals("0")) {
						student.setBedroomId(bedroom.getBedroomId());
						student.setBedroomName(bedroom.getBedroomName());
						student.setStatus("1");
						discribed.add(student);
						totalBedBoy--;
						bedroom.setTotalBed(String.valueOf(totalBedBoy));
						
					}
				}
			}
			bedrooms.remove(discribed);
		//��Ůͬѧ�Ž�������
			int totalBedGirl=0;
			List<Bedroom> bedroomsGirl = discributionDao.getFreeBedrooms(byClass.getApartmentId2());
		for (Bedroom bedroom : bedroomsGirl) {
			totalBedGirl=Integer.parseInt(bedroom.getTotalBed());
				for (Student student : girls) {
					if(totalBedBoy==0)
						break;
					if(totalBedGirl>0 && student.getStatus().equals("0")) {
						student.setBedroomId(bedroom.getBedroomId());
						student.setBedroomName(bedroom.getBedroomName());
						student.setStatus("1");
						discribed.add(student);
						totalBedGirl--;
						bedroom.setTotalBed(String.valueOf(totalBedGirl));
					}
			}
		}
		 girls.remove(discribed);
		discributionDao.setTotalBeds(bedrooms);
		discributionDao.setTotalBeds(bedroomsGirl);
		discributionDao.setDiscribed(discribed);
		
	
	}

	public void setStudent(DisByStudent disByStudent) {
		// TODO �Զ����ɵķ������
		//���ø�ѧ��������
		DiscributionDao discributionDao = new DiscributionDao();
		try {
			discributionDao.setStudentRoom(disByStudent);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		//���ø����ҵ�״̬
		try {
			discributionDao.setRoomStatus(disByStudent);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	public List<Student> getStudentsInCol(String collegeId) {
		DiscributionDao dao = new DiscributionDao();
		List<Student> students = null;
		try {
			students = dao.getStudentIncol(collegeId);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return students;
	}

	public List<Manager> getManagerList() {
		DiscributionDao dao = new DiscributionDao();
		List<Manager> managers = null;
		try {
			managers = dao.getManagerList();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		
		return managers;
	}



}
