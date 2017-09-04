package com.zhou.test;

import java.sql.SQLException;

import org.junit.Test;

import com.zhou.util.DbcpUtil;

public class DbcpUtilTest {

	@Test
	public void test() {
		try {
			System.out.println(DbcpUtil.getConnection()!=null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
