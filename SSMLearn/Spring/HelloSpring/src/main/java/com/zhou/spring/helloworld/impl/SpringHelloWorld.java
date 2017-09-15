package com.zhou.spring.helloworld.impl;

import com.zhou.spring.helloworld.IHelloWorld;

public class SpringHelloWorld implements IHelloWorld {

	@Override
	public void sayHello() {
		System.out.println("spring：Hello World！");
	}

}
