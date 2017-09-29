package com.zhou.spring.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhou.spring.tx.service.IBookShopService;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = null;
		IBookShopService service = null;
		ctx = new ClassPathXmlApplicationContext("spring-tx/beans-tx.xml");
		service = ctx.getBean("bookShopService", IBookShopService.class);
		service.purchase("zhou", "1001", 2);
	}
}
