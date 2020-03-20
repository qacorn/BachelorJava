package com.class2018071202;

import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
//        Action proxy = (Action) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Action.class},new DynamicProxyHandler(realObject));
        Action proxy = (Action) Proxy.newProxyInstance(RealObject.class.getClassLoader(),new Class[]{Action.class},new DynamicProxyHandler(realObject));
        proxy.doSomething();
    }
}
