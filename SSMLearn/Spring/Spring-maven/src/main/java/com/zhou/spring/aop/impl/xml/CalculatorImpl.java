package com.zhou.spring.aop.impl.xml;


/**
 * 计算器实现类
 * @author zhou
 *
 */
public class CalculatorImpl implements Calculator {

	@Override
	public int add(int i, int j) {
		return i+j;
	}

	@Override
	public int sub(int i, int j) {
		return i-j;
	}

	@Override
	public int mul(int i, int j) {
		return i*j;
	}

	@Override
	public int div(int i, int j) {
		return i/j;
	}


}
