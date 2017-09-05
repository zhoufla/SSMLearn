package com.zhou.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbcpUtil {
	private static Connection conn = null;
	private static DataSource dataSource = null;
	private static Context context;

	// 加载DBCP配置文件
	static {
		try {
			context = new InitialContext();
			// java:comp/env/是java中JNDI固定写法。
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/zhou");

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
		if (conn == null)
			synchronized (Connection.class) {
				if (conn == null)
					conn = dataSource.getConnection();
			}
		return conn;
	}

}
