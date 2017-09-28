package com.zhou.spring.aop.impl.xml;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 将该类声明为一个切面：需要把该类放入到IOC容器中，再声明为一个切面
 * 
 * @author zhou
 *
 */
public class LoggingAspects {
	/**
	 * 声明该方法是一个前置通知：在目标方法之前执行
	 * 
	 * @param joinPoint
	 */
	public void beforeMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinPoint.getArgs());
		System.out.println("The method " + methodName + " begins with " + args);
	}

	/**
	 * 后置通知：无论是否发生异常都执行，不能访问返回值
	 * 
	 * @param joinPoint
	 */
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends ");
	}

	/**
	 * 返回通知：可以访问返回结果
	 * 
	 * @param joinPoint
	 * @param result
	 */
	public void afterMethodReturn(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " ends with " + result);
	}

	/**
	 * 在目标方法出现异常时执行
	 * 
	 * @param joinPoint
	 * @param ex
	 */
	public void afterThrowing(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("The method " + methodName + " occurs exception: " + ex);
	}

	/**
	 * 环绕通知：类似动态代理全过程
	 * 
	 * @param pdj
	 * @return
	 */
	public Object aroundMethod(ProceedingJoinPoint pdj) {
		String methodName = pdj.getSignature().getName();
		List<Object> args = Arrays.asList(pdj.getArgs());
		Object result = null;

		try {
			// 前置通知
			System.out.println("The method " + methodName + " begins with " + args);
			// 执行目标方法
			result = pdj.proceed();
			// 返回通知
			System.out.println("The method " + methodName + " ends with " + result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("The method " + methodName + " occurs exception: " + e);
			e.printStackTrace();
		}
		//后置通知
		System.out.println("The method " + methodName + " ends ");

		return result;
	}

}
