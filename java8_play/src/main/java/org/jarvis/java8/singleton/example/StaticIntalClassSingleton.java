package org.jarvis.java8.singleton.example;

/**
 * 1、这种方式采用了类加载机制来保证初始化实例时只有一个线程
 * 2、巧妙的将实例化Singleton操作放进getInstance方法中，getInstance方法返回静态内部类中实例化好的Singleton
 * 3、类的静态属性只会在第一次加载类的时候初始化，也就是只会初始化一次，在这里，JVM帮我们保证了线程的安全，类在初始化时，别的线程无法进入。
 * 原文链接：https://blog.csdn.net/qq_44543508/article/details/103249751
 * author:Lovel  date:2020/5/19
 */
public class StaticIntalClassSingleton {
    private StaticIntalClassSingleton() {
    }

    //写一个static静态内部类，给该类添加一个static静态instance属性
    private static class SingletonInstance {
        private static final StaticIntalClassSingleton INTAL_CLASS_SINGLETON = new StaticIntalClassSingleton();
    }

    //
    public static synchronized StaticIntalClassSingleton getInstence() {
        return SingletonInstance.INTAL_CLASS_SINGLETON;
    }
}
