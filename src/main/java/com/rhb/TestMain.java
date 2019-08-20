package com.rhb;

import com.rhb.common.DefaultInterceptor;
import com.rhb.common.ProxyBean;
import com.rhb.service.HelloService;
import com.rhb.service.impl.HelloServiceImpl;
import com.rhb.service.impl.HelloServiceImpl2;

/**
 * @author renhuibo  2019-08-19 23:19:28
 * @Description
 */
public class TestMain {
	public static void main(String[] args) {
		HelloService service = new HelloServiceImpl2();
		HelloService proxy = (HelloService) ProxyBean.newProxyInstance(service, new DefaultInterceptor());
		proxy.sayHello();
	}
}
