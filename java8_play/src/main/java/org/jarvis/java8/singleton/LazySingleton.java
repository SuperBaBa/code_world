package org.jarvis.java8.singleton;

/**
 * author:Lovel  date:2020/5/17 特点是在类加载时并没有生成单例，只有当第一次去调用才回去创建单例
 */
public class LazySingleton {
    /*volatile防止指令重排，同时能够让主线程在共同内存中看到该变量的变化*/
    private static volatile LazySingleton instance = null;

    /*不可见构造器，避免在外部进行实例化*/
    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        /*需要在方法前加上重量级别的线程同步锁，CAS(compare and swap)机制*/
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
