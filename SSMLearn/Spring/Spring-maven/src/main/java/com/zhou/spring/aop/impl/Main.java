package com.zhou.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop/beans-aop.xml");

		Calculator calculator = context.getBean("calculatorImpl", Calculator.class);
		
		System.out.println("result:"+calculator.add(2, 5));
		
		System.out.println("result:"+calculator.div(2, 1));

	}

}
