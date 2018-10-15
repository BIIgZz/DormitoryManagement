package com.dormitoryManage.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DataSourceUtils {
		private static DataSource dataSource=new ComboPooledDataSource();
		public static ThreadLocal<Connection> tl = new ThreadLocal<>();
		public static Connection getConnection() throws SQLException {
			Connection connection = tl.get();
			if(connection==null) {
				connection=dataSource.getConnection();
				tl.set(connection);
			}
			return connection;
		} 
		public static DataSource getDataSource() {
			return dataSource;
		}
		
}
