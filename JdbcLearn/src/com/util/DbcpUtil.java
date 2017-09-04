package com.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DbcpUtil {
	private static Connection conn = null;
	private static Properties props = new Properties();
	private static DataSource dataSource = null;

	// 加载DBCP配置文件
	static {
		try {
			InputStream ins = new FileInputStream("config/dbcpconfig.properties");
			props.load(ins);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取连接类
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		conn = dataSource.getConnection();
		return conn;
	}

}
