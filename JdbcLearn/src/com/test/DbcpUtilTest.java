package com.test;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.dao.ItemDAOImpl;
import com.entity.Item;

public class DbcpUtilTest {

	@Test
	public void test() {
		Date a = new Date();
		testDbUtil();
		Date b = new Date();
		System.out.println("直接连接用时:"+(b.getTime()-a.getTime()));
		
		Date c = new Date();
		testDbcpUtil();
		Date d = new Date();
		System.out.println("连接池用时:"+(d.getTime()-c.getTime()));
	}

	public void testDbUtil() {
		for (int i = 0; i < 10; i++) {
			ItemDAOImpl dao = new ItemDAOImpl();
			Item item = new Item();
			item.setCity("北京");
			item.setId(11 + i);
			item.setName("老北京布鞋");
			item.setNumber(200);
			item.setPrice(108.0);
			item.setPicture("001.jpg");
			try {
				dao.insertItem(item);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void testDbcpUtil() {
		for (int i = 0; i < 10; i++) {
			ItemDAOImpl dao = new ItemDAOImpl();
			Item item = new Item();
			item.setCity("北京");
			item.setId(21 + i);
			item.setName("老北京布鞋");
			item.setNumber(200);
			item.setPrice(108.0);
			item.setPicture("001.jpg");
			try {
				dao.insertItem(item);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
