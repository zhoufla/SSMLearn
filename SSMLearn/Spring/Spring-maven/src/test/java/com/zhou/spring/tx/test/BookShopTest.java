package com.zhou.spring.tx.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhou.spring.tx.service.IBookShopService;

public class BookShopTest {
	private ApplicationContext ctx = null;
	private IBookShopService service = null;

	{
		ctx = new ClassPathXmlApplicationContext("spring-tx/beans-tx.xml");
		service = ctx.getBean("bookShopService",IBookShopService.class);
	}

	@Test
	public void testQueryPrice() {
		service.purchase("zhou", "1001", 2);
	}

}
