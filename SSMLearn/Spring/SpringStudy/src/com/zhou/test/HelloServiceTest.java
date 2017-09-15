package com.zhou.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhou.itf.HelloService;

public class HelloServiceTest {

	private ApplicationContext context;

	@Test
	public void testHelloWorld() {
		context = new ClassPathXmlApplicationContext("helloservice.xml");
		// 2、从容器中获取Bean，注意此处完全“面向接口编程，而不是面向实现”
		HelloService helloService = context.getBean("helloService", HelloService.class);
		// 3、执行业务逻辑
		// helloService.sayHello();
		helloService.save("你好！");
	}

}
