# proxy-aop-core
SpringAOP实现原理之动态代理

项目主要结构：  
  
--|common  
    --|Interceptor:  模板化拦截功能  
    --|DefaultInterceptor ： 实现拦截功能  
    --|Invocation： 利用反射机制完成对象调目标方法（method.invoke(obj,args...)）  
    --|ProxyBean: 实现InvocationHandler处理调用代理对象方法流程。  
--|service  
    --|HelloService : 测试所用接口。  
    --|impl  
        --|HelloServiceImpl :　测试接口实现类1  
        --|HelloServiceImpl2:  测试接口实现类2  
--|TestMain: 测试流程  
  
  
核心知识点：  
  1. Proxy和InvocationHandler都在java.lang.reflect包下  
  2. Proxy.newInstance(Classloader cl,Class<?> interfaces,InvocationHandler iHandler)方法中参数的理解：  
      Classloader: 代理类的ClassLoader  
      Class<?> interfaces: 首先是对象的class对象集合，其次是代理类所实现的接口的Class对象集合  
      InvocationHandler： 调用方法的处理器。  
  3. 动态代理硬核需求：  
      a. 代理接口要是用实现类，实现所有接口。  
      b. 自定义的InvocationHandler要实现invoke方法。  
  4. 动态代理实现流程：（自己理解，仍有不足）  
      Proxy.newInstance()方法，帮我们透明化实现代理细节，在调用方法的时候，使用InvovationHandler中invoke方法具体实现。    
     
        
知识不足点：（JDK源码）  
  1. JDK中Proxy.newInstance()透明化代理，具体实现方式是什么？  
  2. JDK中对于动态代理流程控制，实现细节是怎样控制的？  

排版有点问题，有时间再弄一下*--*
