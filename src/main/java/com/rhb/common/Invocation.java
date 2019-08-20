package com.rhb.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author renhuibo  2019-08-19 23:06:55
 * @Description : 反射调用类中方法
 */
@Getter
@Setter
@AllArgsConstructor
public class Invocation {
	private Object target;
	private Method method;
	private Object[] params;
	
	public Object proceed() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return method.invoke(target, params);
	}
	
}
