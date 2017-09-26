package com.zhou.spring.aop.calculator;

public class Main {
	public static void main(String[] args) {
		Calculator calculator =  new CalculatorImpl();
		CalculatorLoggingProxy proxy = new CalculatorLoggingProxy(calculator);
		Calculator target = proxy.getLoggingProxy();
		
		System.out.println(target.add(1, 2));
		System.out.println(target.mul(1, 2));
	}
}
