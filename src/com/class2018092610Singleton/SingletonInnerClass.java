package com.class2018092610Singleton;

public class SingletonInnerClass {


    private SingletonInnerClass() {

    }

    //利用了classloader的机制来保证初始化instance时只有一个线程，所以也是线程安全的，同时没有性能损耗，所以一般我倾向于使用这一种。

//    注解：定义一个私有的内部类，在第一次用这个嵌套类时，会创建一个实例类型为SingletonLazy的类，只有在Singleton.getInstance()中调用，由于私有的属性，他人无法使用SingleHolder，不调用Singleton.getInstance()就不会创建实例。优点：达到了lazy loading的效果，即按需创建实例。
//
//            ---------------------
//
//    本文来自 木村牧村 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/a303549861/article/details/53028349?utm_source=copy

//    加载一个类时，其内部类不会同时被加载。一个类被加载，当且仅当其某个静态成员（静态域、构造器、静态方法等）被调用时发生
// 该“静态内部类”实现单例模式的方式，在单例对象占用资源大，需要延时加载的情况下优选。。
    private static class SingletonLazy{
        private static final SingletonInnerClass SINGLETON_INNER_CLASS = new SingletonInnerClass();
    }

    public static SingletonInnerClass getInstance() {
        return SingletonLazy.SINGLETON_INNER_CLASS;
    }
}
