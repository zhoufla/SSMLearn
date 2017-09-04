package com.test;

import java.sql.SQLException;

import org.junit.Test;

import com.dao.ItemDAO;
import com.dao.ItemDAOImpl;
import com.entity.Item;

public class ItemDAOTest {

	@Test
	public void test() {
		ItemDAO dao = new ItemDAOImpl();
		Item item = new Item();
		item.setCity("北京");
		item.setId(11);
		item.setName("老北京布鞋");
		item.setNumber(200);
		item.setPrice(108.0);
		item.setPicture("001.jpg");
		try {
			// dao.deleteItem(item);
			// dao.insertItem(item);
			dao.updateItem(item);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testQuery() {
		ItemDAO dao = new ItemDAOImpl();
		try {
			Item item = dao.queryItemById(10);
			System.out.println(item.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
