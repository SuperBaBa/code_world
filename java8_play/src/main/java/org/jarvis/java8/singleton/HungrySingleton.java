package org.jarvis.java8.singleton;

/**
 * author:Lovel  date:2020/5/17
 */
public class HungrySingleton {
    /*饿汉式，在类加载时就已经创建了一个单例*/
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    private HungrySingleton getInstance() {
        return instance;
    }
}
