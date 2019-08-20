package com.rhb.common;

import java.lang.reflect.InvocationTargetException;

/**
 * @author renhuibo  2019-08-19 23:21:57
 * @Description : 自定拦截器实现类
 */
public class DefaultInterceptor implements Interceptor {

	@Override
	public void before() {
		System.out.println("before...");
	}

	@Override
	public void after() {
		System.out.println("after...");
	}

	@Override
	public Object around(Invocation invocation) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		System.out.println("around before...");
		Object target = invocation.proceed();
		System.out.println("around after...");
		return target;
	}

	@Override
	public boolean userAround() {
		return true;
	}

	@Override
	public void afterReturning() {
		System.out.println("afterReturning...");
	}

	@Override
	public void afterThrowing() {
		System.out.println("afterThrowing...");
	}

}
