package com.zhou.spring.helloworld;

public class HelloWorldService {
	private IHelloWorld helloWorld;

	public HelloWorldService() {

	}

	public void setHelloWorld(IHelloWorld helloWorld) {
		this.helloWorld = helloWorld;
	}

	public IHelloWorld getHelloWorld() {
		return this.helloWorld;
	}
}
