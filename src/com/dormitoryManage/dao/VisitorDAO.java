package com.dormitoryManage.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dormitoryManage.dbutils.DataSourceUtils;
import com.dormitoryManage.domain.Announcement;
import com.dormitoryManage.domain.Visitor;

public class VisitorDAO {

	public void create(Visitor visitor) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into visitor(visitorName,visitorSex,visitorCall,bedroomName,reason,visitorDate) values (?,?,?,?,?,?);";
		Object[] params = {visitor.getVisitorName(),visitor.getVisitorSex(),visitor.getVisitorCall(),visitor.getBedroomName(),visitor.getReason(),visitor.getVisitorDate()};
		queryRunner.update(sql,params);
	}

	public List<Visitor> search(String date, String bedroom) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = null;
		if(date.equals("")){
			if(bedroom.equals("")){
				sql = "select * from visitor order by visitorDate desc,visitorId";
			}else{
				sql = "select * from visitor where bedroomName = '" + bedroom + "' order by visitorDate desc,visitorId"; 
			}
		}else{
			if(bedroom.equals("")){
				sql = "select * from visitor where visitorDate > '" + date + "' order by visitorDate desc,visitorId";
			}else{
				sql = "select * from visitor where visitorDate > '" + date + "' and bedroomName = '" + bedroom + "' order by visitorDate desc,visitorId";
			}
		}
//		System.out.println(sql);
		List<Visitor> list = queryRunner.query(sql, new BeanListHandler<Visitor>(Visitor.class));
		return list;
	}

	public List<Visitor> search() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from visitor group by bedroomName";
		List<Visitor> list = queryRunner.query(sql, new BeanListHandler<Visitor>(Visitor.class));
		return list;
	}

	public List<Visitor> sear(String key, String date) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql =null;
		if(date==null){
			sql = "select * from  visitor where visitorName like '%" + key + "%' or reason like '" + key + "' order by visitorDate desc,visitorId;";
		}else{
			sql = "select * from  visitor where visitorDate > '" + date + "' and visitorId in (select visitorId from visitor where visitorName like '%" + key + "%' or reason like '" + key + "' order by visitorDate desc,visitorId";
		}
		List<Visitor> list = queryRunner.query(sql, new BeanListHandler<Visitor>(Visitor.class));
		return list;
	}

	public Visitor get(String visitorId) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from visitor where visitorId = ?";
		Visitor visitor = queryRunner.query(sql, new BeanHandler<Visitor>(Visitor.class),visitorId);
		return visitor;
	}

	public void update(String visitorId, String visitorName, String visitorCall, String visitorSex, String bedroomName,
			String reason) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update visitor set visitorName = ?,visitorCall = ?,visitorSex = ?,bedroomName = ?,reason = ? where visitorId = ?";
		Object[] params = {visitorName,visitorCall, visitorSex,bedroomName,reason,visitorId};
		queryRunner.update(sql,params);
	}

	public void delete(String visitorId) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = " delete from visitor where visitorId = ? ";
		Object[] params = {visitorId};
		queryRunner.update(sql, params);
	}

	public List<Visitor> searchAll() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from visitor order by visitorDate desc;";
		List<Visitor> list = queryRunner.query(sql, new BeanListHandler<Visitor>(Visitor.class));
		return list;
	}

}
