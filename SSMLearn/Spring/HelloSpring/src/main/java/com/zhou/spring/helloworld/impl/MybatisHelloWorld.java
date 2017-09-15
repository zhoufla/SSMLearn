package com.zhou.spring.helloworld.impl;

import com.zhou.spring.helloworld.IHelloWorld;

public class MybatisHelloWorld implements IHelloWorld {

	@Override
	public void sayHello() {
		System.out.println("Mybatis:Hello World!");
	}

}
