package com.dormitoryManage.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dormitoryManage.dbutils.DataSourceUtils;
import com.dormitoryManage.domain.Announcement;
import com.dormitoryManage.domain.Visitor;

public class AnnounceDAO {
	

	
	public void create(Announcement announcement) throws SQLException{
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into announcement(content,createtime,title) values (?,?,?);";
		Object[] params = {announcement.getContent(), announcement.getCreateTime(), announcement.getTitle()};
		queryRunner.update(sql,params);
	}

	public List<Announcement> search(String date) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = null;
		if(date.equals("")){
			sql = "select * from announcement order by createtime desc";
		}else{
			sql = "select * from announcement where createtime > '" + date + "' order by createtime desc";
		}
//		System.out.println(date);
//		String sql = "select * from announcement";
		List<Announcement> list = queryRunner.query(sql, new BeanListHandler<Announcement>(Announcement.class));
		return list;
	}


	public List<Announcement> sear(String key,String date) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql =null;
		if(date.equals("")){
			sql = "select * from  announcement where title like '%" + key + "%' order by createtime desc;";
		}else{
			sql = "select * from announcement where createtime > '" + date + "'  and title like '%" + key + "%' order by createtime desc";
		}
		List<Announcement> list = queryRunner.query(sql, new BeanListHandler<Announcement>(Announcement.class));
		return list;
	}

	public Announcement get(String announcementId) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from announcement where announcementId = ?";
		Announcement announcement = queryRunner.query(sql, new BeanHandler<Announcement>(Announcement.class),announcementId);
		return announcement;
	}

	public void update(String announcementId, String content, String title) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update announcement set title = ?,content = ? where announcementId = ?";
		Object[] params = {title, content, announcementId};
		queryRunner.update(sql,params);
		
	}

	public void delete(String announcementId) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = " delete from announcement where announcementId = ? ";
		Object[] params = {announcementId};
		queryRunner.update(sql, params);
	}

	public List<Announcement> searchAll() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from announcement order by createtime desc;";
		List<Announcement> list = queryRunner.query(sql, new BeanListHandler<Announcement>(Announcement.class));
		return list;
	}

}
