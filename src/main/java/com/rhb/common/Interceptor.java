package com.rhb.common;

import java.lang.reflect.InvocationTargetException;

/**
 * @author renhuibo  2019-08-19 22:42:45
 * @Description : 定义切面编程基本流程
 */
public interface Interceptor {

	public void before();
	
	public void after();
	
	public Object around(Invocation invocation) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	public boolean userAround();
	
	public void afterReturning();
	
	public void afterThrowing();
	
}
