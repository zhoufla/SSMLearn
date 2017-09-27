package com.zhou.spring.aop.impl;

import org.springframework.stereotype.Component;

/**
 * 计算器实现类
 * @author zhou
 *
 */
@Component
public class CalculatorImpl implements Calculator {

	@Override
	public double add(double i, double j) {
		return i+j;
	}

	@Override
	public double sub(double i, double j) {
		return i-j;
	}

	@Override
	public double mul(double i, double j) {
		return i*j;
	}

	@Override
	public double div(double i, double j) {
		return i/j;
	}


}
