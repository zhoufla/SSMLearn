package com.zhou.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 通过mybatis访问数据库类
 * 
 * @author zhou
 *
 */
public class DBAccess {
	private static SqlSessionFactory sqlSessionFactory;
	private static SqlSession sqlSession;

	static {
		String resource = "com/zhou/config/configuration.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	/**
	 * 获取SqlSession
	 * 
	 * @return
	 */
	public static SqlSession getSqlSession() {
		sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
	}

}
