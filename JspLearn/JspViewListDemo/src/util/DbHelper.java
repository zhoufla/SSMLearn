package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接工具类
 * 
 * @author zhou
 *
 */
public class DbHelper {

	private static final String DRIVER = "com.mysql.jdbc.Driver";// 数据库驱动
	private static final String URL = "jdbc:mysql://localhost:3306/zhou?useUnicode=true&characterEncoding=UTF-8";// 连接数据库url地址
	private static final String USERNAME = "root";// 用户名
	private static final String PASSWORD = "root";// 密码

	private static Connection conn = null;
	// 静态代码块负责加载驱动
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 通过单例模式获取连接类
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		if (conn == null) {
			synchronized (Connection.class) {
				if (conn == null) {
					conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				}
			}
		}
		return conn;
	}

}
