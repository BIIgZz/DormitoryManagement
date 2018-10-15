package com.dormitoryManage.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.dormitoryManage.dbutils.DataSourceUtils;
import com.dormitoryManage.domain.Announcement;
import com.dormitoryManage.domain.Bedroom;

public class BedroomDAO {

	public void create(Bedroom bedroom) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into bedroom(apartmentId,bedroomName,totalBed) values (?,?,?);";
		Object[] params = {bedroom.getApartmentId(), bedroom.getBedroomName(), bedroom.getTotalBed()};
		queryRunner.update(sql,params);
		
	}

	public List<Bedroom> search(String flag) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = null;
		if(flag.equals("N")){
			sql = "select * from bedroom where totalbed < 4 order by bedroomId ";
		}else if(flag.equals("Y")){
			sql = "select * from bedroom where totalBed = 4 order by bedroomId";
		}else{
			sql = "select * from bedroom order by bedroomId";
		}
		List<Bedroom> list = queryRunner.query(sql, new BeanListHandler<Bedroom>(Bedroom.class));
		return list;
	}

	public List<Bedroom> sear(String key, String arg) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql =null;
		if(arg.equals("Y")){
			sql = "select * from bedroom where totalBed = 4 and bedroomName like '%" + key + "%' order by bedroomId ;";
		}else if(arg.equals("N")){
			sql = "select * from bedroom where totalBed < 4 and bedroomName like '%" + key + "%' order by bedroomId";
		}else{
			sql = "select * from bedroom where bedroomName like '%" + key + "%' order by bedroomId ";
		}
		List<Bedroom> list = queryRunner.query(sql, new BeanListHandler<Bedroom>(Bedroom.class));
		return list;
	}

	public Bedroom get(String bedroomId) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from bedroom where bedroomId = ?";
		Bedroom bedroom = queryRunner.query(sql, new BeanHandler<Bedroom>(Bedroom.class),bedroomId);
		return bedroom;
	}

	public void update(String bedroomId, String bedroomName, String totalBed) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "update bedroom set bedroomName = ?,totalBed = ? where bedroomId = ?";
		Object[] params = {bedroomName, totalBed, bedroomId};
		queryRunner.update(sql,params);
	}
	
	public static void add() {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="insert into bedroom (apartmentid ,bedroomName) values(?,?)";
		String temp=null;
		for(int i=2;i<30;i++) {
			
				for(int j=5*100+1;j<=5*100+26;j++) {
					temp=i+"-"+j;
					try {
						queryRunner.update(sql,i,temp);
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				
			}
		}
	}


}
