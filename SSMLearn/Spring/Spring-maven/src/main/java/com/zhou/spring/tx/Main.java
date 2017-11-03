package com.zhou.spring.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhou.spring.tx.service.IBookShopService;

public class Main {
//	@SuppressWarnings("resource")
//	public static void main(String[] args) {
//		ApplicationContext ctx = null;
//		IBookShopService service = null;
//		ctx = new ClassPathXmlApplicationContext("spring-tx/beans-tx.xml");
//		service = ctx.getBean("bookShopService", IBookShopService.class);
//		service.purchase("zhou", "1001", 2);
//	}
	
	static int MAX =10;
	public static void sum(double sum,int n) {
		if (n<MAX) {
			sum += (double)Math.pow(-1, n)*(1.0/n);
			sum(sum,n+1);
		}else {
			System.out.println(sum);
		}
	}
	
	public static void main(String[] args) {
		sum(1.0,2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
