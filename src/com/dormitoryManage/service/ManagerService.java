package com.dormitoryManage.service;

import java.sql.SQLException;
import java.util.List;

import com.dormitoryManage.dao.ManagerDao;
import com.dormitoryManage.domain.Manager;
import com.dormitoryManage.domain.ManagerAdd;
import com.dormitoryManage.domain.Page;

public class ManagerService {

	public Manager getManager(String managerId) {
		ManagerDao dao = new ManagerDao();
		Manager manager = null;
		try {
			manager = dao.getManager(managerId);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return manager;
	}

	public void updateManager(String managerName, String managerCall, String managerId) {
		// TODO �Զ����ɵķ������
		ManagerDao dao = new ManagerDao();
		try {
			dao.updateManager(managerName,managerCall,managerId);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}

	public static Page<Manager> fingPage(int pageNow, int pageTotal) throws SQLException {
		// TODO �Զ����ɵķ������
		ManagerDao dao = new ManagerDao();
		Page page = new Page<>();
		page.setPageNo(pageNow);
		page.setPageTotal(pageTotal);
		int total = dao.getTotal();
		int totalPage= (int) Math.ceil(1.0*total/pageTotal);
		page.setTotalPage(totalPage);
		int index=(pageNow-1)*pageTotal;
		List<Manager> list=dao.findListForPage(index,pageTotal);
		page.setPageList(list);
		return page;
	}

	public void addManager(ManagerAdd add) {
		// TODO �Զ����ɵķ������
		ManagerDao dao = new ManagerDao();
		try {
			dao.addManager(add);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}

	public void deleteManager(String managerId) {
		// TODO �Զ����ɵķ������
		ManagerDao dao = new ManagerDao();
		try {
			dao.deleteManager(managerId);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}

	public List<Manager> searchManager(String key) {
		// TODO �Զ����ɵķ������
		ManagerDao dao = new ManagerDao();
		List<Manager> managers = null;
		try {
			managers = dao.searchManager(key);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return managers;
	}

}
