package com.zhou.test;

import java.sql.SQLException;

import org.junit.Test;

import com.zhou.dao.MessageDAOImpl;

public class MessageDAOImplTest {

	@Test
	public void test() {
		try {
			System.out.println(new MessageDAOImpl().queryAllMessages());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
