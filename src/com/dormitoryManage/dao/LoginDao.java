package com.dormitoryManage.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.dormitoryManage.dbutils.DataSourceUtils;
import com.dormitoryManage.domain.User;
import com.sun.xml.internal.bind.v2.util.DataSourceSource;

public class LoginDao {

	public User login(String name, String password) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql="select * from user where name=? and password=?";
		User user = queryRunner.query(sql, new BeanHandler<User>(User.class),name,password);
		return user;

	}

}
