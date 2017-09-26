package com.zhou.jdbc.congfig;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	private static AbstractApplicationContext context;

	public static void main(String[] args) {
		context = new ClassPathXmlApplicationContext("jdbcpool.xml");
		DataSource dataSource = context.getBean("dataSource", DataSource.class);
		try {
			System.out.println("-------->"+dataSource.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		context.close();
	}
}
