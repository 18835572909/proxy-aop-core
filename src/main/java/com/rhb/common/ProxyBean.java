package com.rhb.common;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author renhuibo  2019-08-19 22:48:07
 * @Description ： 实现动态代理
 */
public class ProxyBean implements InvocationHandler{

	private Object target = null;
	private Interceptor interceptor = null;
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] params){
		boolean exceptionFlag =  false;
		
		Invocation invocation = new Invocation(target, method, params);
		Object retObj = null;
		try {
			if(this.interceptor.userAround()) {
				retObj = this.interceptor.around(invocation);
			}else {
				retObj = method.invoke(target, params);
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			exceptionFlag =true;
		}
		
		this.interceptor.after();
		if(exceptionFlag) {
			this.interceptor.afterThrowing();
		}else {
			this.interceptor.afterReturning();
			return retObj;
		}
		return null;
	}

	public static Object newProxyInstance(Object target,Interceptor interceptor) {
		ProxyBean proxyBean = new ProxyBean();
		proxyBean.interceptor = interceptor;
		proxyBean.target = target;
		/**
		 * 动态代理的核心方法：
		 * 	
		 */
		Object proxy = Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				proxyBean); 
		
		return proxy;
	}
	
}
