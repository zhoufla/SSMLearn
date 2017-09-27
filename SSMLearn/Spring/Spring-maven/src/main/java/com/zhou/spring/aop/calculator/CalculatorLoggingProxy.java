package com.zhou.spring.aop.calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 动态代理：日志
 * 
 * @author zhou
 *
 */
public class CalculatorLoggingProxy {
	// 要代理的对象
	private Calculator target = null;

	public CalculatorLoggingProxy(Calculator target) {
		this.target = target;
	}

	public CalculatorLoggingProxy() {
	}

	public Calculator getLoggingProxy() {
		Calculator proxy = null;

		// 代理对象由哪一个类加载器负责加载
		ClassLoader loader = target.getClass().getClassLoader();
		// 代理对象的类型,即其中有哪些方法
		Class<?>[] interfaces = new Class[] { Calculator.class };
		//当调用代理对象中的方法时，该执行的代码
		InvocationHandler h = new InvocationHandler() {
			/**
			 * proxy:需要返回的代理对象 method:正在执行代理的方法 args:调用方法传入的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("The method " + method.getName() + " begin with " + Arrays.asList(args));
				Object result = method.invoke(target, args);
				System.out.println("The method " + method.getName() + " end with " + result);
				return result;
			}
		};

		proxy = (Calculator) Proxy.newProxyInstance(loader, interfaces, h);

		return proxy;
	}

}
